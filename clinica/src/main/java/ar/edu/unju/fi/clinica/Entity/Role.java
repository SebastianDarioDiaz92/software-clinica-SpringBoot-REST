/**
 * 
 */
package ar.edu.unju.fi.clinica.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 * @author Diaz, Sebastián Darío
 * Entidad Rol.
 */
@Entity
@Table(name = "Roles")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
    private Long idRol;
    @Column(nullable = false, unique = true)
    private String descriptionRol;
    @ManyToMany(mappedBy = "roles")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users = new ArrayList<>();
	
	public Role() {
	}

	public Role(Long id, String name, List<User> users) {
		super();
		this.idRol = id;
		this.descriptionRol = name;
		this.users = users;
	}

	public Role(String name, List<User> users) {
		super();
		this.descriptionRol = name;
		this.users = users;
	}

	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long id) {
		this.idRol = id;
	}
	public String getDescriptionRol() {
		return descriptionRol;
	}
	public void setDescriptionRol(String name) {
		this.descriptionRol = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [idRol=" + idRol + ", descriptionRol=" + descriptionRol + ", users=" + users + "]";
	}	
}
