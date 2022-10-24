/**
 * 
 */
package ar.edu.unju.fi.clinica.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

/**
 * @author Diaz, Sebastián Darío
 * Entidad Office, representa a Consultorio.
 */
@Entity
@Table(name = "Consultorio")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_office")
	private Long idOffice;
	@Column(name = "floor_office")
	private String floor;
	@Column(name = "number_office")
	private Integer numberOffice;
	
	@Column(name = "description_office")
	private String descriptionOffice;
	
	@Column(name = "identifier_office")
	private String visualIdentifier;
	
	/*@OneToOne(mappedBy = "office")
	private Doctor doctor;*/
	
	public Office() {
		// TODO Auto-generated constructor stub
	}

	public Office(Long idOffice, String floor, Integer numberOffice, String descriptionOffice, String visualIdentifier) {
		super();
		this.idOffice = idOffice;
		this.floor = floor;
		this.numberOffice = numberOffice;
		this.descriptionOffice = descriptionOffice;
		this.visualIdentifier = visualIdentifier;
	}

	public Office(String floor, Integer numberOffice, String descriptionOffice, String visualIdentifier) {
		super();
		this.floor = floor;
		this.numberOffice = numberOffice;
		this.descriptionOffice = descriptionOffice;
		this.visualIdentifier = visualIdentifier;
	}

	public Long getIdOffice() {
		return idOffice;
	}

	public void setIdOffice(Long idOffice) {
		this.idOffice = idOffice;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Integer getNumberOffice() {
		return numberOffice;
	}

	public void setNumberOffice(Integer numberOffice) {
		this.numberOffice = numberOffice;
	}

	public String getDescriptionOffice() {
		return descriptionOffice;
	}

	public void setDescriptionOffice(String descriptionOffice) {
		this.descriptionOffice = descriptionOffice;
	}

	public String getVisualIdentifier() {
		return visualIdentifier;
	}

	public void setVisualIdentifier(String visualIdentifier) {
		this.visualIdentifier = visualIdentifier;
	}

	@Override
	public String toString() {
		return "Office [idOffice=" + idOffice + ", floor=" + floor + ", numberOffice=" + numberOffice + ", descriptionOffice="
				+ descriptionOffice + ", visualIdentifier=" + visualIdentifier + "]";
	}		
	
}
