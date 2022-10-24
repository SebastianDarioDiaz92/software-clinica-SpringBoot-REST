/**
 * 
 */
package ar.edu.unju.fi.clinica.Service;

import java.util.List;
import ar.edu.unju.fi.clinica.DTO.DoctorDTO;

/**
 * @author Diaz, Sebastián Darío
 * Interfaz de servicio de Doctor.
 */
public interface DoctorService {

	/**
	 * Método que permite Añadir un Doctor.
	 * @param doctorDTO - doctor: DoctorDTO
	 */
	public void addDoctor(DoctorDTO doctorDTO);
	
	/**
	 * Método que permite Actualizar un Doctor.
	 * @param doctorDTOOriginal - Doctor Original: DoctorDTO
	 * @param doctorDTOUpdated - Doctor Actualizado: DoctorDTO
	 */
	public void updateDoctor(DoctorDTO doctorDTOOriginal, DoctorDTO doctorDTOUpdated);
	
	/**
	 * Método que permite Eliminar un Doctor.
	 * @param doctorDTO - doctor: DoctorDTO
	 */
	public void deleteDoctor(DoctorDTO doctorDTO);
	
	/**
	 * Método que busca un Doctor, mediante su número de licencia.
	 * @param licenseNumber - número de licencia: Integer
	 * @return Un Objeto de tipo DoctorDTO.
	 */
	public DoctorDTO findDoctorByLicenseNumber(Integer licenseNumber);
	
	/**
	 * Método que busca Doctores, mediante su número de turno.
	 * @param turn - turno: String
	 * @return Un List que contiene Objetos de tipo DoctorDTO.
	 */
	public List<DoctorDTO> findDoctorsByTurn(String turn);
	
	/**
	 * Método que lista todos los Doctores almacenados.
	 * @return Un List que contiene Objetos de tipo DoctorDTO.
	 */
	public List<DoctorDTO> listDoctor();
	
	/**
	 * Método que permite añadir un Doctor, y lo retorna como DoctorDTO.
	 * @param doctorDTO - doctor: DoctorDTO
	 * @return 
	 */
	public DoctorDTO addDoctorDTO(DoctorDTO doctorDTO);
	/**
	 * Método que busca un Doctor, mediante su ID. Retorna un Objeto de tipo DoctorDTO.
	 * @param idDoctor - ID: Long
	 * @return Un Objeto de tipo DoctorDTO.
	 */
	public DoctorDTO findDoctorByID(Long idDoctor);
	
	/**
	 * Método que permite Eliminar un Doctor, mediante su ID.
	 * @param idDoctor - ID: Long
	 */
	public void deleteDoctorByID(Long idDoctor);
}
