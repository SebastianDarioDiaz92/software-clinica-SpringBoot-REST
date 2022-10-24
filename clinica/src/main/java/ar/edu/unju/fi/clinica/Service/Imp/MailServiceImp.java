/**
 * 
 */
package ar.edu.unju.fi.clinica.Service.Imp;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.clinica.Service.MailService;

/**
 * @author Diaz, Sebastián Darío
 * Clase de implementación del servicio MailService.
 */
@Service
public class MailServiceImp implements MailService{
	private static final Logger log = Logger.getLogger(MailServiceImp.class);
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendMail(String from, String to, String subject, String body) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(from);
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setText(body);
			javaMailSender.send(mailMessage);
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public void sendMimeMessage(String from, String to, String subject, String body) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			 
			helper.setSubject(subject);
			helper.setFrom(from);
			helper.setTo(to); 
			boolean html = true;
			helper.setText(body, html);
			 
			javaMailSender.send(message);
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}	
	}
}
