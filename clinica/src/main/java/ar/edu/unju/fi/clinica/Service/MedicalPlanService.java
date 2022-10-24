/**
 * 
 */
package ar.edu.unju.fi.clinica.Service;

import java.util.List;

import ar.edu.unju.fi.clinica.DTO.MedicalPlanDTO;

/**
 * @author Diaz, Sebastián Darío
 * Interfaz de servicios de MedicalPlan.
 */
public interface MedicalPlanService {

	/**
	 * Método que permite Añadir un MedicalPlan.
	 * @param medicalPlanDTO - obra social: MedicalPlanDTO
	 */
	public void addMedicalPlan(MedicalPlanDTO medicalPlanDTO);
	
	/**
	 * Método que permite Añadir un MedicalPlan. Retorna un Objeto de tipo MedicalPlanDTO.
	 * @param medicalPlanDTO - obra social: MedicalPlanDTO
	 * @return Un Objeto de tipo MedicalPlanDTO.
	 */
	public MedicalPlanDTO addMedicalPlanDTO(MedicalPlanDTO medicalPlanDTO);
	
	/**
	 * Método que permite Actualizar un MedicalPlan.
	 * @param medicalPlanDTOOriginal - obra social original: MedicalPlanDTO
	 * @param medicalPlanDTOUpdated - obra social actualizada: MedicalPlanDTO
	 */
	public void updateMedicalPlan(MedicalPlanDTO medicalPlanDTOOriginal, MedicalPlanDTO medicalPlanDTOUpdated);
	
	/**
	 * Método que permite Eliminar un MedicalPlan.
	 * @param medicalPlanDTO - obra social: MedicalPlanDTO
	 */
	public void deleteMedicalPlan(MedicalPlanDTO medicalPlanDTO);
	
	/**
	 * Método que busca un MedicalPlan, mediante su nombre empresarial.
	 * @param businessName - nombre empresarial: String
	 * @return Un Objeto de tipo MedicalPlanDTO.
	 */
	public MedicalPlanDTO findMedicalPlanByBusinessName(String businessName);
	
	/**
	 * Método que cuenta la cantidad de MedicalPlan almacenados y retorna el valor entero.
	 * @return Un Objeto de tipo Integer.
	 */
	public Integer countMedicalPlan();
	
	/**
	 * Método que lista todos los MedicalPlan almacenados.
	 * @return Un List que contiene Objetos de tipo MedicalPlanDTO.
	 */
	public List<MedicalPlanDTO> getAllMedicalPlan();
	
	/**
	 * Método que busca un MedicalPlan, mediante su ID.
	 * @param idMedicalPlan - ID: Long
	 * @return Un Objeto de tipo MedicalPlanDTO.
	 */
	public MedicalPlanDTO findMedicalPlanById(Long idMedicalPlan);
	
	/**
	 * Método que Elimina un MedicalPlan, mediante su ID.
	 * @param idMedicalPlan - ID: Long
	 */
	public void deleteMedicalPlanById(Long idMedicalPlan);
}
