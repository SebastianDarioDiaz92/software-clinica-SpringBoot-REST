/**
 * 
 */
package ar.edu.unju.fi.clinica.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Diaz, Sebastián Darío
 * Clase que implementa el patrón Data Transfer Object sobre la entidad Role.
 */
public class RoleDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long idRol;
	private String descriptionRol;
	private List<UserDTO> users = new ArrayList<>();
	
	public RoleDTO() {
	}
	
	public RoleDTO(String descriptionRol) {
		super();
		this.descriptionRol = descriptionRol;
	}

	public RoleDTO(Long idRol, String descriptionRol, List<UserDTO> users) {
		super();
		this.idRol = idRol;
		this.descriptionRol = descriptionRol;
		this.users = users;
	}
	public RoleDTO(String descriptionRol, List<UserDTO> users) {
		super();
		this.descriptionRol = descriptionRol;
		this.users = users;
	}

	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getDescriptionRol() {
		return descriptionRol;
	}
	public void setDescriptionRol(String descriptionRol) {
		this.descriptionRol = descriptionRol.toUpperCase();
	}

	@Override
	public String toString() {
		return "RoleDTO [idRol=" + idRol + ", descriptionRol=" + descriptionRol + ", users=" + users + "]";
	}
}
