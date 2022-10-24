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

import ar.edu.unju.fi.clinica.DTO.UserDTO;

/**
 * @author Diaz, Sebastián Darío
 * Clase de configuración del archivo .PDF contenedor del listado de usuarios registrados.
 */
public class UserExportPDF {

	private static final Logger log = Logger.getLogger(UserExportPDF.class);
	private List<UserDTO> listUsers;

	public UserExportPDF(List<UserDTO> listUsers) {
        this.listUsers = listUsers;
    }
	
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        //ROJO
        cell.setBackgroundColor(new Color(200,40,40));
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("NOMBRE", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("APELLIDO", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("USUARIO", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("E-MAIL", font));
        table.addCell(cell);       
    }
	
	private void writeTableData(PdfPTable table) {
        for (UserDTO user : listUsers) {
            table.addCell(user.getFirstName());
            table.addCell(user.getLastName());
            table.addCell(user.getNameUser());
            table.addCell(user.getEmail());
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
             
            Paragraph p = new Paragraph("LISTADO DE USUARIOS", font);
            p.setAlignment(Paragraph.ALIGN_CENTER);
             
            document.add(p);
             
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100f);
            table.setWidths(new float[] {3.0f, 3.0f, 3.0f, 4.5f});
            table.setSpacingBefore(10);
             
            writeTableHeader(table);
            writeTableData(table);
             
            document.add(table);
             
            document.close();
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}   
    }
	
	public List<UserDTO> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<UserDTO> listUsers) {
		this.listUsers = listUsers;
	}
}
