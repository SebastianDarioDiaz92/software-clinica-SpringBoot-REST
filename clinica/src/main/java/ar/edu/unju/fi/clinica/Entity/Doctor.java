/**
 * 
 */
package ar.edu.unju.fi.clinica.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 * @author Diaz, Sebastián Darío
 * Entidad Doctor, extiende de Person.
 */
@Entity
@Table(name = "Doctores")
@PrimaryKeyJoinColumn(referencedColumnName = "person_id")
public class Doctor extends Person {

	@Column(name = "Matricula")
	private Integer licenseNumber;
	
	@Column(name = "Turno")
	private String turn;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "doctors_plans", joinColumns = {
			@JoinColumn(name = "doctor_id", referencedColumnName = "person_id") }, inverseJoinColumns = {
					@JoinColumn(name = "plan_id", referencedColumnName = "id_medicalplan") })
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<MedicalPlan> listMedicalPlans= new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Office_ID", nullable = false)
	private Office office;

	public Doctor() {
	}

	public Doctor(Integer licenseNumber, String turn, List<MedicalPlan> listMedicalPlans, Office office) {
		super();
		this.licenseNumber = licenseNumber;
		this.turn = turn;
		this.listMedicalPlans = listMedicalPlans;
		this.office = office;
	}

	public Doctor(Long idPerson, String firstName, String lastName, String email) {
		super(idPerson, firstName, lastName, email);
	}

	public Doctor(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}

	public Doctor(Integer licenseNumber, String turn, List<MedicalPlan> listMedicalPlans) {
		super();
		this.licenseNumber = licenseNumber;
		this.turn = turn;
		this.listMedicalPlans = listMedicalPlans;
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

	public List<MedicalPlan> getListMedicalPlans() {
		return listMedicalPlans;
	}

	public void setListMedicalPlans(List<MedicalPlan> listMedicalPlans) {
		this.listMedicalPlans = listMedicalPlans;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "Doctor [licenseNumber=" + licenseNumber + ", turn=" + turn + ", listMedicalPlans=" + listMedicalPlans
				+ ", office=" + office + "]";
	}
}
