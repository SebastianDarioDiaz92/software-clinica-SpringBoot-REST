/**
 * 
 */
package ar.edu.unju.fi.clinica.Entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Diaz, Sebastián Darío
 * Entidad Meeting, representa a Turno.
 */
@Entity
@Table(name = "Turnos")
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMeeting;
	
	@Column(name = "Hora_Inicio_Turno")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:ss")
	private LocalDateTime startMeeting;
	
	@Column(name = "Hora_Final_Turno")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:ss")
	private LocalDateTime endMeeting;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "Doctor_ID")
	private Doctor doctorMeeting;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "Paciente_ID", referencedColumnName = "person_id")
	private Patient patientMeeting;
	
	public Meeting() {
	}

	public Meeting(Long idMeeting, LocalDateTime startMeeting, LocalDateTime endMeeting, Doctor doctorMeeting,
			Patient patientMeeting) {
		super();
		this.idMeeting = idMeeting;
		this.startMeeting = startMeeting;
		this.endMeeting = endMeeting;
		this.doctorMeeting = doctorMeeting;
		this.patientMeeting = patientMeeting;
	}

	public Meeting(LocalDateTime startMeeting, LocalDateTime endMeeting, Doctor doctorMeeting, Patient patientMeeting) {
		super();
		this.startMeeting = startMeeting;
		this.endMeeting = endMeeting;
		this.doctorMeeting = doctorMeeting;
		this.patientMeeting = patientMeeting;
	}

	public Long getIdMeeting() {
		return idMeeting;
	}

	public void setIdMeeting(Long idMeeting) {
		this.idMeeting = idMeeting;
	}

	public LocalDateTime getStartMeeting() {
		return startMeeting;
	}

	public void setStartMeeting(LocalDateTime startMeeting) {
		this.startMeeting = startMeeting;
	}

	public LocalDateTime getEndMeeting() {
		return endMeeting;
	}

	public void setEndMeeting(LocalDateTime endMeeting) {
		this.endMeeting = endMeeting;
	}

	public Doctor getDoctorMeeting() {
		return doctorMeeting;
	}

	public void setDoctorMeeting(Doctor doctorMeeting) {
		this.doctorMeeting = doctorMeeting;
	}

	public Patient getPatientMeeting() {
		return patientMeeting;
	}

	public void setPatientMeeting(Patient patientMeeting) {
		this.patientMeeting = patientMeeting;
	}

	@Override
	public String toString() {
		return "Meeting [idMeeting=" + idMeeting + ", startMeeting=" + startMeeting + ", endMeeting=" + endMeeting
				+ ", doctorMeeting=" + doctorMeeting + ", patientMeeting=" + patientMeeting + "]";
	}
}
