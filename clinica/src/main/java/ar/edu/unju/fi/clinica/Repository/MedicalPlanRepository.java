/**
 * 
 */
package ar.edu.unju.fi.clinica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.clinica.Entity.MedicalPlan;


/**
 * @author Diaz, Sebastián Darío
 * Repositorio de la Entidad MedicalPlan. Extiende de JPARepository.
 */
@Repository
public interface MedicalPlanRepository extends JpaRepository<MedicalPlan, Long>{

	/**
	 * Método que busca un MedicalPlan, mediante su nombre empresarial.
	 * @param businessNameMedicalPlan - Nombre Empresarial: String
	 * @return MedicalPlan.
	 */
	MedicalPlan findByBusinessNameMedicalPlan(String businessNameMedicalPlan);
	
	/**
	 * Método que busca un MedicalPlan, mediante su ID.
	 * @param idMedicalPlan - ID: Long
	 * @return MedicalPlan.
	 */
	MedicalPlan findByIdMedicalPlan(Long idMedicalPlan);
	//List<MedicalPlan> findByAddressMedicalPlanLike(String likePattern);
	/*@Query("SELECT m FROM MedicalPlan m WHERE m.businessName = :business")
	MedicalPlan findMedicalPlanByBusiness( @Param("business") String bussinesName);*/
}
