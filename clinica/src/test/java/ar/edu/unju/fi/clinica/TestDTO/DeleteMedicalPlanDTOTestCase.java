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

import ar.edu.unju.fi.clinica.DTO.MedicalPlanDTO;
import ar.edu.unju.fi.clinica.Service.MedicalPlanService;

/**
 * @author Diaz, Sebastián Darío
 * Test Eliminar una ObraSocial.
 */
@SpringBootTest
class DeleteMedicalPlanDTOTestCase {

	private static Logger log = Logger.getLogger(DeleteMedicalPlanDTOTestCase.class);
	
	@Autowired
	private MedicalPlanService medicalPlanService;
	
	private MedicalPlanDTO searchMedicalPlan;
	
	private Integer quantityMedicalPlan;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		quantityMedicalPlan = medicalPlanService.countMedicalPlan();
		log.info("Cantidad de objetos iniciales: " + quantityMedicalPlan);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		try {
			searchMedicalPlan = medicalPlanService.findMedicalPlanByBusinessName("OSDE");
			medicalPlanService.deleteMedicalPlan(searchMedicalPlan);
			Integer quantity = quantityMedicalPlan-1;
			assertTrue(quantity==2);
			log.info("Cantidad de objetos final: " + quantity);
		} catch (Exception e) {
			log.debug(e.getCause());
		}
	}

}
