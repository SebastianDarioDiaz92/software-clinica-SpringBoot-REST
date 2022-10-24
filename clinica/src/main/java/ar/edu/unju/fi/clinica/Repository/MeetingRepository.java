/**
 * 
 */
package ar.edu.unju.fi.clinica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.clinica.Entity.Meeting;
import ar.edu.unju.fi.clinica.Entity.Patient;


/**
 * @author Diaz, Sebastián Darío
 * Repositorio de la Entidad Meeting. Extiende de JPARepository.
 */
@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long>{

	/**
	 * Método que busca un Meeting, mediante un Patient.
	 * @param patientMeeting - Paciente: Patient
	 * @return Meeting.
	 */
	Meeting findByPatientMeeting(Patient patientMeeting);
	
	/**
	 * Método que busca un Meeting, mediante su ID.
	 * @param idMeeting - ID: Long
	 * @return Meeting.
	 */
	Meeting findByIdMeeting(Long idMeeting);

}
