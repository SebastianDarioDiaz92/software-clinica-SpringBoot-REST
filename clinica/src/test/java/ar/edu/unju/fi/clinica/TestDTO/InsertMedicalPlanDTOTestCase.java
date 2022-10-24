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
 * Test Insertar 10 Obras Sociales.
 */
@SpringBootTest
class InsertMedicalPlanDTOTestCase {

	private static Logger log = Logger.getLogger(InsertMedicalPlanDTOTestCase.class);
	@Autowired
	private MedicalPlanService medicalPlanService;
	
	private MedicalPlanDTO medicalPlanDTO;
	private MedicalPlanDTO medicalPlanDTO2;
	private MedicalPlanDTO medicalPlanDTO3;
	private MedicalPlanDTO medicalPlanDTO4;
	private MedicalPlanDTO medicalPlanDTO5;
	private MedicalPlanDTO medicalPlanDTO6;
	private MedicalPlanDTO medicalPlanDTO7;
	private MedicalPlanDTO medicalPlanDTO8;
	private MedicalPlanDTO medicalPlanDTO9;
	private MedicalPlanDTO medicalPlanDTO10;
	
	private Integer quantity;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		quantity = medicalPlanService.countMedicalPlan();
		medicalPlanDTO = new MedicalPlanDTO("INSTITUTO DE SEGUROS DE JUJUY", "Alvear N° 745 – S. S. de Jujuy (C.P.4600) – Jujuy – Argentina", "0800 444 0984");
		medicalPlanDTO2 = new MedicalPlanDTO("OSDE", "Av. 19 de Abril 551 - S. S. de Jujuy (C.P. 4600) – Jujuy – Argentina", "0800 555 6733");
		medicalPlanDTO3 = new MedicalPlanDTO("SWISS MEDICAL", "Av. Corrientes 1865 PB CABA", "0800 222 7854");	
		medicalPlanDTO4 = new MedicalPlanDTO("OSPRERA", "Reconquista 630 - (1003) Capital Federal", "+54 (011) 4312-2500");
		medicalPlanDTO5 = new MedicalPlanDTO("OSPM", "Venezuela 1427", "0810-777-8733");
		medicalPlanDTO6 = new MedicalPlanDTO("OSPIT", "Av. La Plata 754 1º Piso", "4924-8484");
		medicalPlanDTO7 = new MedicalPlanDTO("OSPE", "Av. Leandro N. Alem 690 (C1001AAO)", "0800 444 OSPE (6773)");
		medicalPlanDTO8 = new MedicalPlanDTO("OSPAT", "Av. Roque Sáenz Peña 832 Piso 3°", "011 5070-2000");
		medicalPlanDTO9 = new MedicalPlanDTO("OSPACP", "Av.44 N°390 E/2 y 3 - La Plata", "0221-4220930");	
		medicalPlanDTO10 = new MedicalPlanDTO("OSMEDICA", "Gral. San Martín 1085 -SAN SALV. JUJUY", "(0388)-4235025");
	}
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		log.info("Limpiando Variables.");
		medicalPlanDTO = null;
		medicalPlanDTO2 = null;
		medicalPlanDTO3 = null;
		medicalPlanDTO4 = null;
		medicalPlanDTO5 = null;
		medicalPlanDTO6 = null;
		medicalPlanDTO7 = null;
		medicalPlanDTO8 = null;
		medicalPlanDTO9 = null;
		medicalPlanDTO10 = null;
		quantity=null;
	}

	@Test
	void testInsertMedicalPlan() {
		try {
			medicalPlanService.addMedicalPlan(medicalPlanDTO);
			medicalPlanService.addMedicalPlan(medicalPlanDTO2);
			medicalPlanService.addMedicalPlan(medicalPlanDTO3);
			medicalPlanService.addMedicalPlan(medicalPlanDTO4);
			medicalPlanService.addMedicalPlan(medicalPlanDTO5);
			medicalPlanService.addMedicalPlan(medicalPlanDTO6);
			medicalPlanService.addMedicalPlan(medicalPlanDTO7);
			medicalPlanService.addMedicalPlan(medicalPlanDTO8);
			medicalPlanService.addMedicalPlan(medicalPlanDTO9);
			medicalPlanService.addMedicalPlan(medicalPlanDTO10);
			quantity = medicalPlanService.countMedicalPlan();
			log.info("...INICIANDO TEST...");
			log.info("Cantidad de Obras Sociales agregadas: " + quantity);
			assertTrue(quantity.equals(10));
			log.info("...FINALIZÓ TEST...");
		} catch (Exception e) {
			log.debug(e.getCause());
		}
	}
}
