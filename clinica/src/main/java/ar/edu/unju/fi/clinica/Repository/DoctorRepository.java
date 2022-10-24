/**
 * 
 */
package ar.edu.unju.fi.clinica.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.clinica.Entity.Doctor;


/**
 * @author Diaz, Sebastián Darío
 * Repositorio de la Entidad Doctor. Extiende de JPARepository.
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	/**
	 * Método que busca un Doctor, mediante su número de licencia.
	 * @param licenseNumber - Número de Licencia: Integer
	 * @return Doctor.
	 */
	Doctor findByLicenseNumber(Integer licenseNumber);
	List<Doctor> findByTurn(String turn);
	
	/**
	 * Método que busca un Doctor, mediante su ID.
	 * @param idPerson - ID: Long
	 * @return Doctor.
	 */
	@Query("SELECT d FROM Person d WHERE d.idPerson= :idPerson")
	Doctor findDoctorById(@Param("idPerson") Long idPerson);
	
}
