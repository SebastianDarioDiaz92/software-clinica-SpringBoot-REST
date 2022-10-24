/**
 * 
 */
package ar.edu.unju.fi.clinica.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.clinica.Entity.Office;

/**
 * @author Diaz, Sebastián Darío
 * Repositorio de la Entidad Office. Extiente de JPARepository.
 */
@Repository
public interface OfficeRepository extends JpaRepository<Office, Long>{

	/**
	 * Método que busca un Office, mediante su número de consultorio.
	 * @param numberOffice - Número de Consultorio: Integer
	 * @return Office.
	 */
	Office findByNumberOffice(Integer numberOffice);
	
	/**
	 * Método que busca un Office, según el piso donde se encuentra el consultorio.
	 * @param floor - Piso: String
	 * @return Office.
	 */
	List<Office> findByFloor(String floor);
	
	/**
	 * Método que busca un Office, mediante su ID.
	 * @param idOffice - ID: Long
	 * @return Office.
	 */
	Office findByIdOffice(Long idOffice);
	
	/**
	 * Método que busca un Office, mediante su descripción.
	 * @param descriptionOffice - Descripción: String
	 * @return Office.
	 */
	List<Office> findByDescriptionOffice(String descriptionOffice);
}
