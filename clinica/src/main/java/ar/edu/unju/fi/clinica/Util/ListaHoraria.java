/**
 * 
 */
package ar.edu.unju.fi.clinica.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diaz, Sebastián Darío
 *
 */
public class ListaHoraria {

	public ListaHoraria() {
	}
	
	/**
	 * Lista horaria a modo de ejemplo.
	 * @return List que contiene horarios disponibles del día.
	 */
	public  static List<Horario> listTimesFull(){
		List<Horario> lista = new ArrayList<>();		
		Boolean status = true;
		
		Horario horario1 = new Horario(1L, Constante.TIME_START_MORNING, status);
		Horario horario2 = new Horario(2L, horario1.getHora().plusMinutes(30), status);
		Horario horario3 = new Horario(3L, horario2.getHora().plusMinutes(30), status);
		Horario horario4 = new Horario(4L, horario3.getHora().plusMinutes(30), status);
		Horario horario5 = new Horario(5L, horario4.getHora().plusMinutes(30), status);
		Horario horario6 = new Horario(6L, horario5.getHora().plusMinutes(30), status);
		Horario horario7 = new Horario(7L, horario6.getHora().plusMinutes(30), status);
		Horario horario8 = new Horario(8L, horario7.getHora().plusMinutes(30), status);
		lista.add(horario1);
		lista.add(horario2);
		lista.add(horario3);
		lista.add(horario4);
		lista.add(horario5);
		lista.add(horario6);
		lista.add(horario7);
		lista.add(horario8);
		
		Horario horario9 = new Horario(9L, Constante.TIME_START_AFTERNOON, status);
		Horario horario10 = new Horario(10L, horario9.getHora().plusMinutes(30), status);
		Horario horario11 = new Horario(11L, horario10.getHora().plusMinutes(30), status);
		Horario horario12 = new Horario(12L, horario11.getHora().plusMinutes(30), status);
		Horario horario13 = new Horario(13L, horario12.getHora().plusMinutes(30), status);
		Horario horario14 = new Horario(14L, horario13.getHora().plusMinutes(30), status);
		Horario horario15 = new Horario(15L, horario14.getHora().plusMinutes(30), status);
		Horario horario16 = new Horario(16L, horario15.getHora().plusMinutes(30), status);
		
		lista.add(horario9);
		lista.add(horario10);
		lista.add(horario11);
		lista.add(horario12);
		lista.add(horario13);
		lista.add(horario14);
		lista.add(horario15);
		lista.add(horario16);
		return lista;
	}	
}
