/**
 * 
 */
package ar.edu.unju.fi.clinica.DTO;

import java.io.Serializable;

/**
 * @author Diaz, Sebastián Darío
 * Clase que implementa el patrón Data Transfer Object sobre la entidad Patient.
 */
public class PatientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idPerson;
	private String firstName;
	private String lastName;
	private String email;
	private Integer dniPatient;
	private String addressPatient;
	private String phoneNumberPatient;
	private MedicalPlanDTO medicalPlan;
	
	public PatientDTO() {
	}

	public PatientDTO(Long idPerson, String firstName, String lastName, String email, Integer dniPatient,
			String addressPatient, String phoneNumberPatient, MedicalPlanDTO medicalPlan) {
		super();
		this.idPerson = idPerson;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dniPatient = dniPatient;
		this.addressPatient = addressPatient;
		this.phoneNumberPatient = phoneNumberPatient;
		this.medicalPlan = medicalPlan;
	}

	public PatientDTO(String firstName, String lastName, String email, Integer dniPatient, String addressPatient,
			String phoneNumberPatient, MedicalPlanDTO medicalPlan) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dniPatient = dniPatient;
		this.addressPatient = addressPatient;
		this.phoneNumberPatient = phoneNumberPatient;
		this.medicalPlan = medicalPlan;
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

	public MedicalPlanDTO getMedicalPlan() {
		return medicalPlan;
	}

	public void setMedicalPlan(MedicalPlanDTO medicalPlan) {
		this.medicalPlan = medicalPlan;
	}

	@Override
	public String toString() {
		return "PatientDTO [idPerson=" + idPerson + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", dniPatient=" + dniPatient + ", addressPatient=" + addressPatient + ", phoneNumberPatient="
				+ phoneNumberPatient + ", medicalPlan=" + medicalPlan + "]";
	}
}
