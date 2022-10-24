/**
 * 
 */
package ar.edu.unju.fi.clinica.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Diaz, Sebastián Darío
 * Clase de utilidad, contenedora de constantes posibles para la configuración de horarios de atención.
 */
public class Constante {

	public static final String ROLE_OPERATOR = "ROLE_OPERATOR";
	public static final String ROLE_ADMINISTRATOR = "ROLE_ADMINISTRATOR";
	public static final String TURN_AFTERNOON = "TARDE";
	public static final String TURN_MOORNING = "MAÑANA";
	private static Date date = new Date();
	private static LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	private static Integer year  = localDate.getYear();
	private static Integer month = localDate.getMonthValue();
	private static Integer day   = localDate.getDayOfMonth();
	//private static LocalDateTime fechaInicio = LocalDateTime.of(year, month, day, 6, 0);
	//private static LocalDateTime fechaFin = LocalDateTime.of(year, month, day, 22, 0);

	public static final Integer DURATION_TURN_SINGLE = 30;
	public static final Integer DURATION_TURN_LONG = 60;

	//public static final LocalDateTime HORA_INICIO = fechaInicio;	
	//public static final LocalDateTime HORA_FIN = fechaFin;
	
	
	//public static final Integer TODAY = LocalDateTime.now().getDayOfMonth();
	public static final Integer HOUR_START_MORNING = 8;
	public static final Integer HOUR_END_MOORNING = 12;
	public static final Integer HOUR_START_AFTERNOON = 16;
	public static final Integer HOUR_END_AFTERNOON = 20;
	
	public static LocalDateTime TIME_START_MORNING = LocalDateTime.of(year, month, day, HOUR_START_MORNING, 0);
	public static LocalDateTime TIME_END_MORNING = LocalDateTime.of(year, month, day, HOUR_END_MOORNING, 0);
	public static LocalDateTime TIME_START_AFTERNOON = LocalDateTime.of(year, month, day, HOUR_START_AFTERNOON, 0);
	public static LocalDateTime TIME_END_AFTERNOON = LocalDateTime.of(year, month, day, HOUR_END_AFTERNOON, 0);
}
