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
 * Entidad MedicalPlan, representa a Obra Social.
 */
@Entity
@Table(name = "ObraSocial")
public class MedicalPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medicalplan")
	private Long idMedicalPlan;
	
	@Column(name = "Obra_Social")
	private String businessNameMedicalPlan;
	
	@Column(name = "Direccion")
	private String addressMedicalPlan;
	
	@Column(name = "Telefono")
	private String phoneNumberMedicalPlan;
	
	@ManyToMany(mappedBy = "listMedicalPlans")
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<Doctor> doctors = new ArrayList<>();
	
	

	public MedicalPlan() {
	}

	public MedicalPlan(Long idMedicalPlan, String businessNameMedicalPlan, String addressMedicalPlan,
			String phoneNumberMedicalPlan) {
		super();
		this.idMedicalPlan = idMedicalPlan;
		this.businessNameMedicalPlan = businessNameMedicalPlan;
		this.addressMedicalPlan = addressMedicalPlan;
		this.phoneNumberMedicalPlan = phoneNumberMedicalPlan;
	}

	public MedicalPlan(String businessNameMedicalPlan, String addressMedicalPlan, String phoneNumberMedicalPlan) {
		super();
		this.businessNameMedicalPlan = businessNameMedicalPlan;
		this.addressMedicalPlan = addressMedicalPlan;
		this.phoneNumberMedicalPlan = phoneNumberMedicalPlan;
	}

	public Long getIdMedicalPlan() {
		return idMedicalPlan;
	}

	public void setIdMedicalPlan(Long idMedicalPlan) {
		this.idMedicalPlan = idMedicalPlan;
	}

	public String getBusinessNameMedicalPlan() {
		return businessNameMedicalPlan;
	}

	public void setBusinessNameMedicalPlan(String businessNameMedicalPlan) {
		this.businessNameMedicalPlan = businessNameMedicalPlan;
	}

	public String getAddressMedicalPlan() {
		return addressMedicalPlan;
	}

	public void setAddressMedicalPlan(String addressMedicalPlan) {
		this.addressMedicalPlan = addressMedicalPlan;
	}

	public String getPhoneNumberMedicalPlan() {
		return phoneNumberMedicalPlan;
	}

	public void setPhoneNumberMedicalPlan(String phoneNumberMedicalPlan) {
		this.phoneNumberMedicalPlan = phoneNumberMedicalPlan;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "MedicalPlan [idMedicalPlan=" + idMedicalPlan + ", businessNameMedicalPlan=" + businessNameMedicalPlan
				+ ", addressMedicalPlan=" + addressMedicalPlan + ", phoneNumberMedicalPlan=" + phoneNumberMedicalPlan
				+ ", doctors=" + doctors + "]";
	}
}
