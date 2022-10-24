/**
 * 
 */
package ar.edu.unju.fi.clinica.View;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import ar.edu.unju.fi.clinica.Entity.Meeting;
import ar.edu.unju.fi.clinica.Util.FormatLocalDate;

/**
 * @author Diaz, Sebastián Darío
 * Clase de configuración del archivo .PDF contenedor del listado de turnos.
 */
public class MeetsExportPDF {

	private static final Logger log = Logger.getLogger(UserExportPDF.class);
	private List<Meeting> listMeets;

	public MeetsExportPDF(List<Meeting> listMeets) {
        this.listMeets= listMeets;
    }
	
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        //ROJO
        cell.setBackgroundColor(new Color(200,40,40));
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("PACIENTE", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("DOCTOR", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("HORA_INICIO", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("HORA_FIN", font));
        table.addCell(cell);       
        
        cell.setPhrase(new Phrase("CONSULTORIO", font));
        table.addCell(cell);  
    }
	
	private void writeTableData(PdfPTable table) {
        for (Meeting meet : listMeets) {
            table.addCell(meet.getPatientMeeting().getFirstName() + " " + meet.getPatientMeeting().getLastName());
            table.addCell(meet.getDoctorMeeting().getFirstName() + " " + meet.getDoctorMeeting().getLastName());
            table.addCell(FormatLocalDate.formatterLocalDateTimeToString(meet.getStartMeeting()));
            table.addCell(FormatLocalDate.formatterLocalDateTimeToString(meet.getEndMeeting()));
            table.addCell(" N°" + meet.getDoctorMeeting().getOffice().getNumberOffice() +" "+ meet.getDoctorMeeting().getOffice().getFloor());
        }
    }
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
        try {
        	Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());
             
            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(18);
            //VERDE
            font.setColor(new Color(30,160,70));
             
            Paragraph p = new Paragraph("LISTADO DE TURNOS", font);
            p.setAlignment(Paragraph.ALIGN_CENTER);
             
            document.add(p);
             
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100f);
            table.setWidths(new float[] {3.5f, 3.5f, 3.5f, 3.5f,3.0f});
            table.setSpacingBefore(10);
             
            writeTableHeader(table);
            writeTableData(table);
             
            document.add(table);
             
            document.close();
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}   
    }

	public List<Meeting> getListMeets() {
		return listMeets;
	}

	public void setListMeets(List<Meeting> listMeets) {
		this.listMeets = listMeets;
	}
	
}
