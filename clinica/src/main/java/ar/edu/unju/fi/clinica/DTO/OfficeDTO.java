/**
 * 
 */
package ar.edu.unju.fi.clinica.DTO;

import java.io.Serializable;

/**
 * @author Diaz, Sebastián Darío
 * Clase que implementa el patrón Data Transfer Object sobre la entidad Office.
 */
public class OfficeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idOffice;
	private String floor;
	private Integer numberOffice;
	private String descriptionOffice;
	private String visualIdentifier;
	
	public OfficeDTO() {
	}

	public OfficeDTO(String floor, Integer numberOffice, String descriptionOffice, String visualIdentifier) {
		super();
		this.floor = floor;
		this.numberOffice = numberOffice;
		this.descriptionOffice = descriptionOffice;
		this.visualIdentifier = visualIdentifier;
	}

	public OfficeDTO(Long idOffice, String floor, Integer numberOffice, String descriptionOffice,
			String visualIdentifier) {
		super();
		this.idOffice = idOffice;
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
		return "OfficeDTO [idOffice=" + idOffice + ", floor=" + floor + ", numberOffice=" + numberOffice
				+ ", descriptionOffice=" + descriptionOffice + ", visualIdentifier=" + visualIdentifier + "]";
	}
}
