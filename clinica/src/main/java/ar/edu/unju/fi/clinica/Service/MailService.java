/**
 * 
 */
package ar.edu.unju.fi.clinica.Service;

/**
 * @author Diaz, Sebastián Darío
 * Interfaz de servicio de Mail.
 */
public interface MailService {

	/**
	 * Método que envía un mensaje simple.
	 * @param from - remitente: String
	 * @param to - destinatario: String
	 * @param subject - asunto: String
	 * @param body - cuerpo del mensaje: String
	 */
	public void sendMail(String from, String to, String subject, String body);
	
	/**
	 * Método que envía un mensaje compuesto.
	 * @param from - remitente: String
	 * @param to - destinatario: String
	 * @param subject - asunto: String 
	 * @param body - cuerpo del mensaje: String
	 */
	public void sendMimeMessage(String from, String to, String subject, String body);
}
