/**
 * 
 */
package ar.edu.unju.fi.clinica.TestDTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.clinica.Service.MailService;

/**
 * @author Diaz, Sebastián Darío
 * Test enviar Email con imágen.
 */
@SpringBootTest
class SendMimeMesaggeTestCase {

	@Autowired
	private MailService mailService;
	
	private String to;
	private String from;
	private String subject;
	private String body;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		from = "emailtesterapi.2022@gmail.com";
		to = "sebastiandario.diaz92@gmail.com";
		subject = "Aviso de Turno";
		
		body = "<head>\n"
				+ "	\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lobster&effect=shadow-multiple\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <style>\r\n"
				+ "        .w3-shadow {\r\n"
				+ "            font-family: 'shadow-multiple', cursive;\r\n"
				+ "        }\r\n"
				+ "        \r\n"
				+ "        .table {\r\n"
				+ "            width: 100%;\r\n"
				+ "            height: 300px;\r\n"
				+ "        }\r\n"
				+ "        \r\n"
				+ "        .w3-panel {\r\n"
				+ "            width: 50%;\r\n"
				+ "            height: 100%;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "        <div class=\"w3-panel w3-pale-indigo w3-border-indigo w3-border \">\r\n"
				+ "            <table class=\"table \">\r\n"
				+ "                <tr class=\"w3-indigo\">\r\n"
				+ "                    <th class=\"w3-container w3-left\">\r\n"
				//+ "                        <img src=\"https://prepagasyobrassociales.com.ar/wp-content/uploads/2021/02/Osde-precios.png\" class=\"rounded-circle\" width=\"120\" height=\"100\" alt=\"\">\r\n"
				+ "                        <a href=\"https://ibb.co/2cnpp0j\"><img src=\"https://i.ibb.co/2cnpp0j/clinica-Logologo.png\" alt=\"clinica-Logologo\" border=\"0\" class=\"rounded-circle\" width=\"120\" height=\"100\" alt=\"\">\r\n</a>"
				+ "                    </th>\r\n"
				+ "                    <th class=\"w3-container w3-center\">\r\n"
				+ "                        <h3 class=\"w3-shadow\">\r\n"
				+ "                            <strong>\r\n"
				+ "                              Confirmación de Turno    \r\n"
				+ "                            </strong>\r\n"
				+ "                        </h3>\r\n"
				+ "                    </th>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                    <td colspan=\"2\">\r\n"
				+ "\r\n"
				+ "                        <h5 class=\"w3-shadow\"> <b> Estimada/o paciente:</b></h5>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "                        <p class=\"w3-shadow\"> Le informamos que se realizó con éxito la solicitud del turno. </p>\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                    <td>\r\n"
				+ "                        <h4 class=\"w3-shadow\"><b>Paciente: </b></h4>\r\n"
				+ "                    </td>\r\n"
				+ "                    <td>\r\n"
				+ "                        <p class=\"w3-shadow\">PACIENTE</p>\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                    <td>\r\n"
				+ "                        <h4 class=\"w3-shadow\"><b> Médico:</b></h4>\r\n"
				+ "                    </td>\r\n"
				+ "                    <td>\r\n"
				+ "                        <p class=\"w3-shadow\">MEDICO</p>\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                    <td>\r\n"
				+ "                        <h4 class=\"w3-shadow\"><b> Fecha y hora:</b></h4>\r\n"
				+ "                    </td>\r\n"
				+ "                    <td>\r\n"
				+ "                        <p class=\"w3-shadow\">15/11/2021 10:00</p>\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                    <td>\r\n"
				+ "                        <h4 class=\"w3-shadow\"><b> Lugar:</b> </h4>\r\n"
				+ "                    </td>\r\n"
				+ "                    <td>\r\n"
				+ "                        <p class=\"w3-shadow\">LUGAR</p>\r\n"
				//+ "                        <p class=\"w3-shadow\"> Av. 19 de Abril 551</p>\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                    <td>\r\n"
				+ "                        <h4 class=\"w3-shadow\"><b> Teléfono:</b></h4>\r\n"
				+ "                    </td>\r\n"
				+ "                    <td>\r\n"
				+ "                        <p class=\"w3-shadow\">TELEFONO</p>\r\n"
				+ "\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                    <td class=\"w3-container w3-center\" colspan=\"2\">\r\n"
				+ "                        <p class=\"w3-shadow\">Asistir 15 minutos antes del turno establecido. </p>\r\n"
				+ "                        <p class=\"w3-shadow\">Ante cualquier inconveniente no dude en comunicarse con nosotros. </p>\r\n"
				+ "                        <p class=\"w3-shadow\">Saludos atentamente</p>\r\n"
				+ "                    </td>\r\n"
				+ "                </tr>\r\n"
				+ "\r\n"
				+ "            </table>\r\n"
				+ "\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>\n"			
				;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		mailService.sendMimeMessage(from, to, subject,body);
		assertTrue(true);
	}

}
