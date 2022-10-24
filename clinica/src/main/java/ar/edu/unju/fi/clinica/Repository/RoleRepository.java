/**
 * 
 */
package ar.edu.unju.fi.clinica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.clinica.Entity.Role;

/**
 * @author Diaz, Sebastián Darío
 * Repositorio de la Entidad Role. Extiende de JPARepository.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	/**
	 * Método que busca un Role, mediante su ID.
	 * @param idRol - ID: Long
	 * @return Role.
	 */
	Role findByIdRol(Long idRol);
	
	/**
	 * Método que busca un Role, mediante su descripción.
	 * @param descriptionRol - Descripción: String
	 * @return Role.
	 */
	Role findByDescriptionRol(String descriptionRol);
}
