/**
 * 
 */
package ar.edu.unju.fi.clinica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.clinica.Entity.Patient;

/**
 * @author Diaz, Sebastián Darío
 * Repositorio de la Entidad Patient. Extiende de JPARepository.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	/**
	 * Método que busca un Patient, mediante su D.N.I.
	 * @param dniPatient - D.N.I.: Integer 
	 * @return Patient.
	 */
	Patient findByDniPatient(Integer dniPatient);

	/**
	 * Método que busca un Patient, mediante su ID.
	 * @param idPerson - ID: Long
	 * @return Patient.
	 */
	@Query("SELECT d FROM Person d WHERE d.idPerson= :idPerson")
	Patient findPatientById(@Param("idPerson") Long idPerson);
	//@Query("SELECT p FROM Patient p WHERE p.idPerson = :idPerson")
	//Patient findPatientByDNI (@Param("idPerson") Long idPerson );
	/*@Query("SELECT m FROM MedicalPlan m WHERE m.businessName = :business")
	MedicalPlan findMedicalPlanByBusiness( @Param("business") String bussinesName);*/
}
