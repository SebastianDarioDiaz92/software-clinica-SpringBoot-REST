/**
 * 
 */
package ar.edu.unju.fi.clinica.Service;

import java.util.List;

import ar.edu.unju.fi.clinica.DTO.MeetingDTO;
import ar.edu.unju.fi.clinica.DTO.PatientDTO;
import ar.edu.unju.fi.clinica.Entity.Meeting;

/**
 * @author Diaz, Sebastián Darío
 * Interfaz de servicio Meeting.
 */
public interface MeetingService {

	/**
	 * Método que permite Añadir un Meeting.
	 * @param meetingDTO - turno: MeetingDTO
	 */
	public void addMeeting(MeetingDTO meetingDTO);
	
	/**
	 * Método que permite Añadir un Meeting. Retorna un MeetingDTO.
	 * @param meetingDTO - turno: MeetingDTO
	 * @return Un Objeto de tipo MeetingDTO.
	 */
	public MeetingDTO addMeetingDTO(MeetingDTO meetingDTO); 
	
	/**
	 * Método que permite Actualizar un Meeting.
	 * @param meetingDTOOriginal - turno original: MeetingDTO
	 * @param meetingDTOUpdated - turno actualizado: MeetingDTO
	 */
	public void updateMeeting(MeetingDTO meetingDTOOriginal, MeetingDTO meetingDTOUpdated);
	
	/**
	 * Método que permite Eliminar un Meeting.
	 * @param meetingDTO - turno: MeetingDTO
	 */
	public void deleteMeeting(MeetingDTO meetingDTO);
	
	/**
	 * Método que busca un Meeting, mediante su ID.
	 * @param idMeeting - ID: Long
	 * @return Un Objeto de tipo MeetingDTO.
	 */
	public MeetingDTO findMeetingById(Long idMeeting);
	
	/**
	 * Método que Elimina un Meeting, mediante su ID.
	 * @param idMeeting - ID: Long
	 */
	public void deleteMeetingById(Long idMeeting);
	
	/**
	 * Método que busca un Meeting, mediante un Patient.
	 * @param patientDTO - paciente: PatientDTO
	 * @return Un Objeto de tipo MeetingDTO.
	 */
	public MeetingDTO findMeetingByPatient(PatientDTO patientDTO);
	
	/**
	 * Método que lista los Meeting almacenados.
	 * @return Un List que contiene Objetos de tipo Meeting.
	 */
	public List<Meeting> listMeeting();
	
	/**
	 * Método que lista los Meeting almacenados, de manera Ascendente.
	 * @return List que contiene Objetos de tipo Meeting ordenados de manera ascendente.
	 */
	public List<Meeting> listMeetingAsc();
}
