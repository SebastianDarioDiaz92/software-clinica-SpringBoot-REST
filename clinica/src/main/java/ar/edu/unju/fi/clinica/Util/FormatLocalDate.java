/**
 * 
 */
package ar.edu.unju.fi.clinica.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Diaz, Sebastián Darío
 * Clase de utilidad que contiene métodos para la conversion de Fechas a String y viceversa.
 */
public class FormatLocalDate {

	public static LocalDateTime formatterStringToLocalDateTime(String date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime dateLocal = LocalDateTime.parse(date, format);
		return dateLocal;
	}
	
	public static String formatterLocalDateTimeToString(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		return localDateTime.format(formatter);		
	}
	
	public static String formatterTimeToString(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return localDateTime.format(formatter);	
	}
	
	public static String formatterLocalDateToString(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return localDateTime.format(formatter);	
	}
}
