/**
 * 
 */
package ar.edu.unju.fi.clinica.Service;

import java.util.List;

import ar.edu.unju.fi.clinica.DTO.RoleDTO;

/**
 * @author Diaz, Sebastián Darío
 * Interfaz de servicio Role.
 */
public interface RoleService {

	/**
	 * Método que permite Añadir un Role.
	 * @param roleDTO - rol: RoleDTO
	 */
	public void addRol(RoleDTO roleDTO);
	
	/**
	 * Método que permite Añadir un Role. Retorna un RoleDTO.
	 * @param roleDTO - rol: RoleDTO
	 * @return Un Objeto de tipo RoleDTO.
	 */
	public RoleDTO addRolDTO(RoleDTO roleDTO);
	
	/**
	 * Método que permite Actualizar un Role.
	 * @param roleDTOOriginal - rol original: RoleDTO
	 * @param roleDTOUpdated - rol actualizado: RoleDTO
	 */
	public void updateRol(RoleDTO roleDTOOriginal, RoleDTO roleDTOUpdated);
	
	/**
	 * Método que permite Eliminar un Role.
	 * @param rolDTO - rol: RoleDTO
	 */
	public void deleteRol(RoleDTO rolDTO);
	
	/**
	 * Método que busca un Role, mediante su ID.
	 * @param idRol - ID: Long
	 * @return Un Objeto de tipo RoleDTO.
	 */
	public RoleDTO findRolByID(Long idRol);
	
	/**
	 * Método que busca un Role, mediante su descripción.
	 * @param descriptionRol - descripción: String
	 * @returnUn Objeto de tipo RoleDTO.
	 */
	public RoleDTO findRolByDescription(String descriptionRol);
	
	/**
	 * Método que lista los Role almacenados.
	 * @return Un List que contiene Objetos de tipo RoleDTO.
	 */
	public List<RoleDTO> listRol();
	
	/**
	 * Método que permite Eliminar un Role, mediante su ID.
	 * @param idRol - ID: Long
	 */
	public void deleteRolByID(Long idRol);
}
