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

import ar.edu.unju.fi.clinica.DTO.RoleDTO;
import ar.edu.unju.fi.clinica.Service.RoleService;

/**
 * @author Diaz, Sebastián Darío
 * Test Insertar 2 Roles.
 */
@SpringBootTest
class InsertRolesTestCase {

	private static Logger log = Logger.getLogger(InsertRolesTestCase.class);
	
	@Autowired
	private RoleService roleService;
	
	private RoleDTO rolDTO;
	private String roldescription;
	private RoleDTO rolDTO2;
	private String roldescription2;
	private Integer quantity;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		roldescription = "role_administrator";
		rolDTO = new RoleDTO(roldescription.toUpperCase());
		roldescription2 = "role_operator";
		rolDTO2 = new RoleDTO(roldescription2.toUpperCase());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		roldescription = null;
		rolDTO = null;
		roldescription2 = null;
		rolDTO2 = null;
	}

	@Test
	void testInsertRoles() {
		try {
			roleService.addRol(rolDTO);
			roleService.addRol(rolDTO2);
			quantity = roleService.listRol().size();
			assertTrue(quantity.equals(2));
		} catch (Exception e) {
			log.debug(e.getCause());
		}
		
	}

}
