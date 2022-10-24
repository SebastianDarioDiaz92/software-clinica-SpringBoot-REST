/**
 * 
 */
package ar.edu.unju.fi.clinica.Util;

import java.time.LocalDateTime;

/**
 * @author Diaz, Sebastián Darío
 *
 */
public class Horario {

	private Long idHorario;
	private LocalDateTime hora;
	private Boolean estatus;
	
	public Horario() {
	}

	public Horario(Long idHorario, LocalDateTime hora, Boolean estatus) {
		super();
		this.idHorario = idHorario;
		this.hora = hora;
		this.estatus = estatus;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	@Override
	public String toString() {
		return "Horario [idHorario=" + idHorario + ", hora=" + hora + ", estatus=" + estatus + "]";
	}
}
