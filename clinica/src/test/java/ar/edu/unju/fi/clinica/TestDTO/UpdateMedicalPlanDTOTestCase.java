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
 * Test Actualizar una Obra Social.
 */
@SpringBootTest
class UpdateMedicalPlanDTOTestCase {

	private static Logger log = Logger.getLogger(UpdateMedicalPlanDTOTestCase.class);
	@Autowired
	private MedicalPlanService medicalPlanService;
	
	private MedicalPlanDTO medicalPlanDTO;
	private MedicalPlanDTO medicalPlanDTOUpdated;
	private MedicalPlanDTO searchmedicalPlanDTO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		medicalPlanDTO = medicalPlanService.findMedicalPlanByBusinessName("Instituto de Seguros");
		medicalPlanDTOUpdated = new MedicalPlanDTO("INSTITUTO DE SEGUROS", "Alvear N° 745 – S. S. de Jujuy (C.P.4600) – Jujuy – Argentina", "0800 444 0984");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		medicalPlanDTO = null;
		medicalPlanDTOUpdated = null;
	}

	@Test
	void testUpdateMedicalPlan() {
		try {
			medicalPlanService.updateMedicalPlan(medicalPlanDTO, medicalPlanDTOUpdated);
			searchmedicalPlanDTO = medicalPlanService.findMedicalPlanByBusinessName("INSTITUTO DE SEGUROS");
			assertTrue(searchmedicalPlanDTO.getBusinessNameMedicalPlan().equals("INSTITUTO DE SEGUROS"));
			log.info("Se actualizó correctamente a " + medicalPlanDTOUpdated);
		} catch (Exception e) {
			log.debug(e.getCause());
		}
	}

}
