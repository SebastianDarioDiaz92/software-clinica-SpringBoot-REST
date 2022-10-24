/**
 * 
 */
package ar.edu.unju.fi.clinica.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Diaz, Sebastián Darío
 * Clase que implementa el patrón Data Transfer Object sobre la entidad Meeting.
 */
public class MeetingDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idMeeting;
	private LocalDateTime startMeeting;
	private LocalDateTime endMeeting;
	private DoctorDTO doctorMeeting;
	private PatientDTO patientMeeting;

	public MeetingDTO() {
	}

	public MeetingDTO(LocalDateTime startMeeting, LocalDateTime endMeeting, DoctorDTO doctorMeeting,
			PatientDTO patientMeeting) {
		super();
		this.startMeeting = startMeeting;
		this.endMeeting = endMeeting;
		this.doctorMeeting = doctorMeeting;
		this.patientMeeting = patientMeeting;
	}

	public MeetingDTO(Long idMeeting, LocalDateTime startMeeting, LocalDateTime endMeeting, DoctorDTO doctorMeeting,
			PatientDTO patientMeeting) {
		super();
		this.idMeeting = idMeeting;
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

	public DoctorDTO getDoctorMeeting() {
		return doctorMeeting;
	}

	public void setDoctorMeeting(DoctorDTO doctorMeeting) {
		this.doctorMeeting = doctorMeeting;
	}

	public PatientDTO getPatientMeeting() {
		return patientMeeting;
	}

	public void setPatientMeeting(PatientDTO patientMeeting) {
		this.patientMeeting = patientMeeting;
	}

	@Override
	public String toString() {
		return "MeetingDTO [idMeeting=" + idMeeting + ", startMeeting=" + startMeeting + ", endMeeting=" + endMeeting
				+ ", doctorMeeting=" + doctorMeeting + ", patientMeeting=" + patientMeeting + "]";
	}
}
