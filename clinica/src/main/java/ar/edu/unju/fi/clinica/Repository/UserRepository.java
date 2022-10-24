/**
 * 
 */
package ar.edu.unju.fi.clinica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.clinica.Entity.User;

/**
 * @author Diaz, Sebastián Darío
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * Método que busca un User, mediante su nombre de usuario (nickname).
	 * @param nameUser - Nombre de Usuario: String
	 * @return User.
	 */
	User findByNameUser(String nameUser);

	/**
	 * Método que busca un User, mediante su email.
	 * @param email - Email: String
	 * @return User.
	 */
	@Query("SELECT u FROM User u WHERE u.email= :email")
	User findUserByEmail(@Param("email") String email);
	
	/*@Query("SELECT u FROM User u WHERE u.nameUser= :userName AND u.passwordUser = :passwordUser"  )
	User findUserByStatusAndNameNamedParams(@Param("userName") String userName , @Param("passwordUser") String passwordUser);*/

}
