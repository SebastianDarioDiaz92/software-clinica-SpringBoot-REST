/**
 * 
 */
package ar.edu.unju.fi.clinica.TestDTO;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.clinica.DTO.UserDTO;
import ar.edu.unju.fi.clinica.Service.UserService;
import ar.edu.unju.fi.clinica.Util.Constante;

/**
 * @author Diaz, Sebastián Darío
 *
 */
@SpringBootTest
class InsertUserTestCase {

	private Logger log  = Logger.getLogger(InsertUserTestCase.class);
	
	@Autowired
	private UserService userService;
	
	private UserDTO user;
	private UserDTO user2;
	private Integer quantity = 0;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		user = new UserDTO("Sebastián Darío", "Diaz", "sebastiandario.sdd@gmail.com", "Dario_ADMIN", "admin", Constante.ROLE_ADMINISTRATOR);
		user2 = new UserDTO("José Alejandro", "Diaz", "darioslipknot2012@gmail.com", "José_OPERATOR", "operator", Constante.ROLE_OPERATOR);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		user=null;
		user2=null;
		quantity=null;
	}

	@Test
	void testAddUser() {
		try {
			userService.addUser(user);
			userService.addUser(user2);
			
			assertTrue(quantity+2 == userService.listUser().size());
		} catch (Exception e) {
			log.debug(e.getCause());
		}
	}

}
