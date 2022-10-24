/**
 * 
 */
package ar.edu.unju.fi.clinica.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author Diaz, Sebastián Darío
 * Clase que implementa el patrón Data Transfer Object sobre la entidad User.
 */
public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idPerson;
	@NotEmpty(message = "Debe completar Nombre Completo")
    private String firstName;
	@NotEmpty(message = "Debe completar Apellido")
    private String lastName;
	@NotEmpty(message = "Debe completar Email")
    @Email
    private String email;
	@NotEmpty(message = "Debe completar Nombre de Usuario")
    private String nameUser;
	@NotEmpty(message = "Debe completar Password")
    private String password;
	
	private String roleUser;
    
	
	public UserDTO(@NotEmpty(message = "Debe completar Nombre Completo") String firstName,
			@NotEmpty(message = "Debe completar Apellido") String lastName,
			@NotEmpty(message = "Debe completar Email") @Email String email,
			@NotEmpty(message = "Debe completar Nombre de Usuario") String nameUser,
			@NotEmpty(message = "Debe completar Password") String password, String roleUser) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.nameUser = nameUser;
		this.password = password;
		this.roleUser = roleUser;
	}

	public UserDTO() {
	}

	public UserDTO(String firstName, String lastName, String email, String nameUser, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.nameUser = nameUser;
		this.password = password;
	}

	public UserDTO(Long idPerson, String firstName, String lastName, String email, String password) {
		super();
		this.idPerson = idPerson;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Long getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

	@Override
	public String toString() {
		return "UserDTO [idPerson=" + idPerson + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", nameUser=" + nameUser + ", password=" + password + ", roleUser=" + roleUser + "]";
	}
}
