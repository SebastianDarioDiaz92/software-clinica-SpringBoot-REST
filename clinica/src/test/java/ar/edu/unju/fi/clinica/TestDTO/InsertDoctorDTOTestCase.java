/**
 * 
 */
package ar.edu.unju.fi.clinica.TestDTO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.clinica.DTO.DoctorDTO;
import ar.edu.unju.fi.clinica.DTO.MedicalPlanDTO;
import ar.edu.unju.fi.clinica.DTO.OfficeDTO;
import ar.edu.unju.fi.clinica.Service.DoctorService;
import ar.edu.unju.fi.clinica.Service.MedicalPlanService;
import ar.edu.unju.fi.clinica.Service.OfficeService;
import ar.edu.unju.fi.clinica.Util.Constante;

/**
 * @author Diaz, Sebastián Darío
 * Test Insertar 10 Doctores.
 */
@SpringBootTest
class InsertDoctorDTOTestCase {

	private static Logger log = Logger.getLogger(InsertDoctorDTOTestCase.class);
	
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private MedicalPlanService medicalPlanService;
	@Autowired
	private OfficeService officeService;
	
	private DoctorDTO doctorDTO;
	private DoctorDTO doctorDTO2;
	private DoctorDTO doctorDTO3;
	private DoctorDTO doctorDTO4;
	private DoctorDTO doctorDTO5;
	private DoctorDTO doctorDTO6;
	private DoctorDTO doctorDTO7;
	private DoctorDTO doctorDTO8;
	private DoctorDTO doctorDTO9;
	private DoctorDTO doctorDTO10;
	
	private List<MedicalPlanDTO> medicalPlans = new ArrayList<>();
	private OfficeDTO officeDTO;
	private OfficeDTO officeDTO2;
	private OfficeDTO officeDTO3;
	private OfficeDTO officeDTO4;
	private OfficeDTO officeDTO5;
	private OfficeDTO officeDTO6;
	private OfficeDTO officeDTO7;
	private OfficeDTO officeDTO8;
	private OfficeDTO officeDTO9;
	private OfficeDTO officeDTO10;
	
	private Integer quantity = 0;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		quantity = doctorService.listDoctor().size();
		officeDTO = officeService.findByNumberOffice(1);
		officeDTO2 = officeService.findByNumberOffice(2);
		officeDTO3 = officeService.findByNumberOffice(3);
		officeDTO4 = officeService.findByNumberOffice(4);
		officeDTO5 = officeService.findByNumberOffice(5);
		officeDTO6 = officeService.findByNumberOffice(6);
		officeDTO7 = officeService.findByNumberOffice(7);
		officeDTO8 = officeService.findByNumberOffice(8);
		officeDTO9 = officeService.findByNumberOffice(9);
		officeDTO10 = officeService.findByNumberOffice(10);
		
		medicalPlans.add(medicalPlanService.getAllMedicalPlan().get(0));
		medicalPlans.add(medicalPlanService.getAllMedicalPlan().get(1));
		doctorDTO = new DoctorDTO("Diana" ,"Lorentz","DLORENTZ@gmail.com",1212,Constante.TURN_MOORNING,officeDTO,medicalPlans);
		doctorDTO2 = new DoctorDTO("Nancy","Greenberg" ,"NGREENBERG@gmail.com",1313,Constante.TURN_MOORNING, officeDTO2, medicalPlans);
		doctorDTO3 = new DoctorDTO("Karen","Colmenares","KCOLMENARES@gmail.com",1414,Constante.TURN_MOORNING,officeDTO3,medicalPlans);
		doctorDTO4 = new DoctorDTO("Neena","Kochhar","NKOCHHAR@gmail.com",1515,Constante.TURN_MOORNING,officeDTO4,medicalPlans);
		doctorDTO5 = new DoctorDTO("Valle","Pataballa","VPATABAL@gmail.com",1616,Constante.TURN_MOORNING,officeDTO5,medicalPlans);
		doctorDTO6 = new DoctorDTO("Denis","Raphaely","KCOLMENARES@gmail.com",1717,Constante.TURN_AFTERNOON,officeDTO6,medicalPlans);
		doctorDTO7 = new DoctorDTO("Shelli","Baida","SBAIDA@gmail.com",1818,Constante.TURN_AFTERNOON,officeDTO7,medicalPlans);
		doctorDTO8 = new DoctorDTO("Pam","Kaufling","PKAUFLIN@gmail.com",1919,Constante.TURN_AFTERNOON,officeDTO8,medicalPlans);
		doctorDTO9 = new DoctorDTO("Julia","Nayer","JNAYER@gmail.com",2020,Constante.TURN_AFTERNOON,officeDTO9,medicalPlans);
		doctorDTO10 = new DoctorDTO("Irene","Mikkilineni","IMIKKILI@gmail.com",2121,Constante.TURN_AFTERNOON,officeDTO10,medicalPlans);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		medicalPlans = null;
		doctorDTO = null;
		doctorDTO2 = null;
		doctorDTO3 = null;
	}

	@Test
	void testInsertDoctor() {
		try {
			doctorService.addDoctor(doctorDTO);
			doctorService.addDoctor(doctorDTO2);
			doctorService.addDoctor(doctorDTO3);
			doctorService.addDoctor(doctorDTO4);
			doctorService.addDoctor(doctorDTO5);
			doctorService.addDoctor(doctorDTO6);
			doctorService.addDoctor(doctorDTO7);
			doctorService.addDoctor(doctorDTO8);
			doctorService.addDoctor(doctorDTO9);
			doctorService.addDoctor(doctorDTO10);
			assertTrue(quantity+10 == doctorService.listDoctor().size());
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

}
