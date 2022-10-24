/**
 * 
 */
package ar.edu.unju.fi.clinica.DTO;

import java.io.Serializable;

/**
 * @author Diaz, Sebastián Darío
 * Clase que implementa el patrón Data Transfer Object sobre la entidad MedicalPlan.
 */
public class MedicalPlanDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idMedicalPlan;
	private String businessNameMedicalPlan;
	private String addressMedicalPlan;
	private String phoneNumberMedicalPlan;

	public MedicalPlanDTO() {
	}

	public MedicalPlanDTO(Long idMedicalPlan, String businessNameMedicalPlan, String addressMedicalPlan,
			String phoneNumberMedicalPlan) {
		super();
		this.idMedicalPlan = idMedicalPlan;
		this.businessNameMedicalPlan = businessNameMedicalPlan;
		this.addressMedicalPlan = addressMedicalPlan;
		this.phoneNumberMedicalPlan = phoneNumberMedicalPlan;
	}

	public MedicalPlanDTO(String businessNameMedicalPlan, String addressMedicalPlan, String phoneNumberMedicalPlan) {
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

	@Override
	public String toString() {
		return "MedicalPlanDTO [idMedicalPlan=" + idMedicalPlan + ", businessNameMedicalPlan=" + businessNameMedicalPlan
				+ ", addressMedicalPlan=" + addressMedicalPlan + ", phoneNumberMedicalPlan=" + phoneNumberMedicalPlan
				+ "]";
	}
}
