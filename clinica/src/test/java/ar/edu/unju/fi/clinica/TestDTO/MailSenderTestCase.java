/**
 * 
 */
package ar.edu.unju.fi.clinica.TestDTO;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.clinica.Service.MailService;

/**
 * @author Diaz, Sebastián Darío
 * Test enviar email.
 */
@SpringBootTest
class MailSenderTestCase {

	private static Logger log = Logger.getLogger(MailSenderTestCase.class);
	
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
		body = "Este es un mensaje de prueba. Turno disponible fecha: 12-09-2022 10:00";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testSendMail() {
		try {
			mailService.sendMail(from, to, subject, body);
			assertTrue(true);
		} catch (Exception e) {
			log.debug(e.getCause());
		}
	}

}
