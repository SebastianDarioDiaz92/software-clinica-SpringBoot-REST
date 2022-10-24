/**
 * 
 */
package ar.edu.unju.fi.clinica.Service;

import java.util.List;

import ar.edu.unju.fi.clinica.DTO.UserDTO;
import ar.edu.unju.fi.clinica.Entity.User;

/**
 * @author Diaz, Sebastián Darío
 * Interfaz de servicio User.
 */
public interface UserService {

	/**
	 * Método que permite Añadir un User.
	 * @param userDTO - usuario: UserDTO
	 */
	public void addUser(UserDTO userDTO);
	
	/**
	 * Método que permite Añadir un User. Retorna un UserDTO.
	 * @param userDTO - usuario: UserDTO
	 * @return Un Objeto de tipo UserDTO.
	 */
	public UserDTO addUserDTO(UserDTO userDTO);
	
	/**
	 * Método que permite Actualizar un User.
	 * @param userDTOOriginal - usuario original: UserDTO
	 * @param userDTOUpdated - usuario actualizado: UserDTO
	 */
	public void updateUser(UserDTO userDTOOriginal, UserDTO userDTOUpdated);
	
	/**
	 * Método que permite Eliminar un User.
	 * @param userDTO - usuario: UserDTO
	 */
	public void deleteUser(UserDTO userDTO);
	
	/**
	 * Método que busca un User, mediante su ID.
	 * @param idUser - ID: Long
	 * @return Un Objeto de tipo UserDTO.
	 */
	public UserDTO findUserByID(Long idUser);
	
	/**
	 * Método que busca un User, mediante su nombre de usuario(nickname).
	 * @param nameUser - nombre de usuario: String
	 * @return Un Objeto de tipo UserDTO.
	 */
	public UserDTO findUserByNameUser(String nameUser);
	
	/**
	 * Método que lista los User almacenados.
	 * @return Un List que contiene Objetos de tipo UserDTO.
	 */
	public List<UserDTO> listUser();
	
	/**
	 * Método que permite Eliminar un User, mediante su ID.
	 * @param idUser - ID: Long
	 */
	public void deleteUserByID(Long idUser);

	/**
	 * Método que busca un User, mediante su e-mail.
	 * @param email - email: String
	 * @return Un Objeto de tipo User.
	 */
	public User findUserByEmail(String email);
	
	/**
	 * Método que lista los User almacenados, de manera Ascendente.
	 * @return Un List que contiene Objetos de tipo UserDTO.
	 */
	public List<UserDTO> listUsersAsc();
}
