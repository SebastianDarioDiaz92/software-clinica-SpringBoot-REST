/**
 * 
 */
package ar.edu.unju.fi.clinica.Service;

import java.util.List;

import ar.edu.unju.fi.clinica.DTO.PatientDTO;

/**
 * @author Diaz, Sebastián Darío
 * Interfaz de servicio de Patient.
 */
public interface PatientService {

	/**
	 * Método que permite Añadir un Patiente.
	 * @param patientDTO - paciente: PatientDTO
	 */
	public void addPatient(PatientDTO patientDTO);
	
	/**
	 * Método que permite Añadir un Patiente. Retorna un PatientDTO.
	 * @param patientDTO - paciente: PatientDTO
	 * @return Un Objeto de tipo PatientDTO.
	 */
	public PatientDTO addPatientDTO(PatientDTO patientDTO);
	
	/**
	 * Método que permite Actualizar un Patient.
	 * @param patientDTOOriginal - paciente original: PatientDTO
	 * @param patientDTOUpdated - paciente actualizado: PatientDTO
	 */
	public void updatePatient(PatientDTO patientDTOOriginal, PatientDTO patientDTOUpdated);
	
	/**
	 * Método que permite Eliminar un Patient.
	 * @param patientDTO - paciente: PatientDTO
	 */
	public void deletePatient(PatientDTO patientDTO);
	
	/**
	 * Método que busca un Patient, mediante su D.N.I.
	 * @param dniPatient - D.N.I.: Integer
	 * @return Un Objeto de tipo PatientDTO.
	 */
	public PatientDTO findPatientByDNI(Integer dniPatient);
	
	/**
	 * Método que lista los Patient almacenados.
	 * @return Un List que contiene Objetos de tipo PatientDTO.
	 */
	public List<PatientDTO> listPatient();
	
	/**
	 * Método que permite Eliminar un Patient, mediante su ID.
	 * @param idPatient - ID: Long
	 */
	public void deletePatientById(Long idPatient);
	
	/**
	 * Método que busca un Patient, mediante su ID.
	 * @param idPatient ID: Long
	 * @return Un Objeto de tipo PatientDTO.
	 */
	public PatientDTO findPatientByID(Long idPatient);
}
