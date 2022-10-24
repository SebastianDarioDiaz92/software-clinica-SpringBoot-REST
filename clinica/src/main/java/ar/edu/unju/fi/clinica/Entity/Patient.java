/**
 * 
 */
package ar.edu.unju.fi.clinica.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Diaz, Sebastián Darío
 * Entidad Paciente, extiende de Person.
 */
@Entity
@Table(name = "Pacientes")
@PrimaryKeyJoinColumn(referencedColumnName = "person_id")
public class Patient extends Person{

	@Column(name = "DNI")
	private Integer dniPatient;
	
	@Column(name = "Paciente_Direccion")
	private String addressPatient;
	
	@Column(name = "Paciente_Telefono")
	private String phoneNumberPatient;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE/*CascadeType.ALL*/)
	@JoinColumn(name = "ObraSocial_ID", nullable = false)
	private MedicalPlan medicalPlan;
	
	public Patient() {
	}

	public Patient(Long idPerson, String firstName, String lastName, String email) {
		super(idPerson, firstName, lastName, email);
	}

	public Patient(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}

	public Patient(String addressPatient, String phoneNumberPatient, MedicalPlan medicalPlan) {
		super();
		this.addressPatient = addressPatient;
		this.phoneNumberPatient = phoneNumberPatient;
		this.medicalPlan = medicalPlan;
	}

	public Patient(Integer dniPatient, String addressPatient, String phoneNumberPatient, MedicalPlan medicalPlan) {
		super();
		this.dniPatient = dniPatient;
		this.addressPatient = addressPatient;
		this.phoneNumberPatient = phoneNumberPatient;
		this.medicalPlan = medicalPlan;
	}

	public Integer getDniPatient() {
		return dniPatient;
	}

	public void setDniPatient(Integer dniPatient) {
		this.dniPatient = dniPatient;
	}

	public String getAddressPatient() {
		return addressPatient;
	}

	public void setAddressPatient(String addressPatient) {
		this.addressPatient = addressPatient;
	}

	public String getPhoneNumberPatient() {
		return phoneNumberPatient;
	}

	public void setPhoneNumberPatient(String phoneNumberPatient) {
		this.phoneNumberPatient = phoneNumberPatient;
	}

	public MedicalPlan getMedicalPlan() {
		return medicalPlan;
	}

	public void setMedicalPlan(MedicalPlan medicalPlan) {
		this.medicalPlan = medicalPlan;
	}

	@Override
	public String toString() {
		return "Patient [dniPatient=" + dniPatient + ", addressPatient=" + addressPatient + ", phoneNumberPatient="
				+ phoneNumberPatient + ", medicalPlan=" + medicalPlan + ", getIdPerson()=" + getIdPerson()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
				+ getEmail() + "]";
	}
}
