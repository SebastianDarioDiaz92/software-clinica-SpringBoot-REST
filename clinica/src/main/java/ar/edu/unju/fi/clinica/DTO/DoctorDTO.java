/**
 * 
 */
package ar.edu.unju.fi.clinica.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Diaz, Sebastián Darío
 * Clase que implementa el patrón Data Transfer Object sobre la entidad Doctor.
 */
public class DoctorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idPerson;
	private String firstName;
	private String lastName;
	private String email;
	private Integer licenseNumber;
	private String turn;
	private OfficeDTO officeDoctor;
	private List<MedicalPlanDTO> listMedicalPlans = new ArrayList<>();
	
	public DoctorDTO() {
	}

	public DoctorDTO(Long idPerson, String firstName, String lastName, String email, Integer licenseNumber, String turn,
			OfficeDTO officeDoctor, List<MedicalPlanDTO> listMedicalPlans) {
		super();
		this.idPerson = idPerson;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.licenseNumber = licenseNumber;
		this.turn = turn;
		this.officeDoctor = officeDoctor;
		this.listMedicalPlans = listMedicalPlans;
	}

	public DoctorDTO(String firstName, String lastName, String email, Integer licenseNumber, String turn,
			OfficeDTO officeDoctor, List<MedicalPlanDTO> listMedicalPlans) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.licenseNumber = licenseNumber;
		this.turn = turn;
		this.officeDoctor = officeDoctor;
		this.listMedicalPlans = listMedicalPlans;
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

	public Integer getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(Integer licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public List<MedicalPlanDTO> getListMedicalPlans() {
		return listMedicalPlans;
	}

	public void setListMedicalPlans(List<MedicalPlanDTO> listMedicalPlans) {
		this.listMedicalPlans = listMedicalPlans;
	}

	public OfficeDTO getOfficeDoctor() {
		return officeDoctor;
	}

	public void setOfficeDoctor(OfficeDTO officeDoctor) {
		this.officeDoctor = officeDoctor;
	}

	@Override
	public String toString() {
		return "DoctorDTO [idPerson=" + idPerson + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", licenseNumber=" + licenseNumber + ", turn=" + turn + ", officeDoctor=" + officeDoctor
				+ ", listMedicalPlans=" + listMedicalPlans + "]";
	}
}
