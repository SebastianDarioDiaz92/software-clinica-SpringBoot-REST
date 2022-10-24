/**
 * 
 */
package ar.edu.unju.fi.clinica.Service;

import java.util.List;

import ar.edu.unju.fi.clinica.DTO.OfficeDTO;

/**
 * @author Diaz, Sebastián Darío
 * Interfaz de servicio Office.
 */
public interface OfficeService {

	/**
	 * Método que permite Añadir un Office.
	 * @param officeDTO - consultorio: OfficeDTO
	 */
	public void addOffice(OfficeDTO officeDTO);
	
	/**
	 * Método que permite Añadir un Office. Retorn un OfficeDTO.
	 * @param officeDTO - consultorio: OfficeDTO
	 * @return Un Objeto de tipo OficeDTO.
	 */
	public OfficeDTO addOfficeDTO(OfficeDTO officeDTO);
	
	/**
	 * Método que permite Actualizar un Office.
	 * @param officeDTOOriginal - consultorio original: OfficeDTO
	 * @param officeDTOUpdated - consultorio actualizado: OfficeDTO
	 */
	public void updateOffice(OfficeDTO officeDTOOriginal, OfficeDTO officeDTOUpdated);
	
	/**
	 * Método que permite Eliminar un Office.
	 * @param officeDTO - consutorio: OfficeDTO
	 */
	public void deleteOffice(OfficeDTO officeDTO);
	
	/**
	 * Método que lista los Office almacenados.
	 * @return Un List que contiene Objetos de tipo OfficeDTO.
	 */
	public List<OfficeDTO> listOffice();
	
	/**
	 * Método que busca un Office, mediante su número de consultorio.
	 * @param numberOffice - número de consultorio: Integer
	 * @return Un Objeto de tipo OficeDTO.
	 */
	public OfficeDTO findByNumberOffice(Integer numberOffice);
	
	/**
	 * Método que filtra los Office almacenados, mediante su descripción.
	 * @param descriptionOffice - descripción: String
	 * @return Un List que contiene Objetos de tipo OfficeDTO.
	 */
	public List<OfficeDTO> findOfficeByDescription(String descriptionOffice);
	
	/**
	 * Método que filtra los Office almacenados, mediante su piso.
	 * @param floorOffice - piso: String
	 * @return Un List que contiene Objetos de tipo OfficeDTO.
	 */
	public List<OfficeDTO> findOfficeByFloor(String floorOffice);
	
	/**
	 * Método que busca un Office, mediante su ID.
	 * @param idOffice - ID: Long
	 * @return Un Objeto de tipo OficeDTO.
	 */
	public OfficeDTO findOfficeById(Long idOffice);
	
	/**
	 * Método que elimina un Office, mediante su ID.
	 * @param idOfFICE - ID: Long
	 */
	public void deleteOfficeById(Long idOffice);
 }
