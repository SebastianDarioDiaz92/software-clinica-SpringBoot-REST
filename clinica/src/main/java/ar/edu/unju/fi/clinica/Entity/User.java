/**
 * 
 */
package ar.edu.unju.fi.clinica.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 * @author Diaz, Sebastián Darío
 * Entidad Usuario.
 */
@Entity
@Table(name = "Usuarios")
@PrimaryKeyJoinColumn(referencedColumnName = "person_id")
public class User extends Person {

	@Column(nullable = false)
	private String nameUser;

	@Column(nullable = false)
	private String password;
	
	@ManyToMany(/*fetch = FetchType.EAGER,*/ cascade = CascadeType.MERGE)
	@JoinTable(name = "users_roles", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "person_id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id_rol") })
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Role> roles = new ArrayList<>();
	
	public User() {
	}

	public User(String name, String password, List<Role> roles) {
		super();
		this.nameUser = name;
		this.password = password;
		this.roles = roles;
	}

	public User(Long idPerson, String firstName, String lastName, String email) {
		super(idPerson, firstName, lastName, email);
	}

	public User(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}

	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String name) {
		this.nameUser = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [nameUser=" + nameUser + ", password=" + password + ", roles=" + roles +  "]";
	}
}
