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
import ar.edu.unju.fi.clinica.DTO.PatientDTO;
import ar.edu.unju.fi.clinica.Service.MedicalPlanService;
import ar.edu.unju.fi.clinica.Service.PatientService;

/**
 * @author Diaz, Sebastián Darío
 * Test Insertar 10 Pacientes.
 */
@SpringBootTest
class InsertPatientDTOTestCase {

	private static Logger log = Logger.getLogger(InsertPatientDTOTestCase.class);

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private MedicalPlanService medicalPlanService;

	private PatientDTO patientDTO;
	private PatientDTO patientDTO2;
	private PatientDTO patientDTO3;
	private PatientDTO patientDTO4;
	private PatientDTO patientDTO5;
	private PatientDTO patientDTO6;
	private PatientDTO patientDTO7;
	private PatientDTO patientDTO8;
	private PatientDTO patientDTO9;
	private PatientDTO patientDTO10;
	
	private MedicalPlanDTO medicalPlanDTO;
	private Integer quantity = 0;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		medicalPlanDTO = medicalPlanService.findMedicalPlanByBusinessName("INSTITUTO DE SEGUROS DE JUJUY");

		patientDTO = new PatientDTO("Matthew" , "Weiss", "sebastiandario.diaz92@gmail.com", 11111111, "Laogianggen 518, Beijing","425-1212", medicalPlanDTO);
		patientDTO2 = new PatientDTO("Adam", "Fripp", "sebastiandario.diaz92@gmail.com", 22222222,"Victoria Street 2901, Sydney","425-3030", medicalPlanDTO);
		patientDTO3 = new PatientDTO("Kevin", "Mourgos", "sebastiandario.diaz92@gmail.com", 33333333, "Charade Rd 9819 Seattle, Washington","425-6060", medicalPlanDTO);
		patientDTO4 = new PatientDTO("Alexander", "Hunold", "sebastiandario.diaz92@gmail.com", 44444444, "2007 Zagora St, New Jersey","420-6660", medicalPlanDTO);
		patientDTO5 = new PatientDTO("Bruce", "Ernst", "sebastiandario.diaz92@gmail.com", 55555555, "6092 Boxwood St, Yukon","402-5640", medicalPlanDTO);
		patientDTO6 = new PatientDTO("David", "Austin", "sebastiandario.diaz92@gmail.com", 66666666, "147 Spadina Ave, Toronto","425-6390", medicalPlanDTO);
		patientDTO7 = new PatientDTO("Daniel", "Faviet", "sebastiandario.diaz92@gmail.com", 77777777, "1298 Vileparle (E), Bombay","424-1112", medicalPlanDTO);
		patientDTO8 = new PatientDTO("John", "Chen", "sebastiandario.diaz92@gmail.com", 88888888, "198 Clementi North, Singapore","423-9785", medicalPlanDTO);
		patientDTO9 = new PatientDTO("Ismael", "Sciarra", "sebastiandario.diaz92@gmail.com", 99999999, "8204 Arthur St, London","425-1313", medicalPlanDTO);
		patientDTO10 = new PatientDTO("Jose Manuel", "Urman", "sebastiandario.diaz92@gmail.com", 10101010, "9702 Chester Road, Manchester","420-0506", medicalPlanDTO);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		medicalPlanDTO = null;
		patientDTO = null;
		patientDTO2 = null;
		patientDTO3 = null;
		patientDTO4 = null;
		patientDTO5 = null;
		patientDTO6 = null;
		patientDTO7 = null;
		patientDTO8 = null;
		patientDTO9 = null;
		patientDTO10 = null;
		quantity = null;
	}

	@Test
	void testInsertPatient() {
		try {
			patientService.addPatient(patientDTO);
			patientService.addPatient(patientDTO2);
			patientService.addPatient(patientDTO3);
			patientService.addPatient(patientDTO4);
			patientService.addPatient(patientDTO5);
			patientService.addPatient(patientDTO6);
			patientService.addPatient(patientDTO7);
			patientService.addPatient(patientDTO8);
			patientService.addPatient(patientDTO9);
			patientService.addPatient(patientDTO10);
			assertTrue(quantity+10 == patientService.listPatient().size());
			
		} catch (Exception e) {
			log.debug(e.getCause());
		}
	}

}
