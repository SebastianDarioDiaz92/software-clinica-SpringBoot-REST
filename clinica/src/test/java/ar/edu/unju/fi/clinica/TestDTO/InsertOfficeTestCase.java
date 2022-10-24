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

import ar.edu.unju.fi.clinica.DTO.OfficeDTO;
import ar.edu.unju.fi.clinica.Service.OfficeService;

/**
 * @author Diaz, Sebastián Darío
 * Test Insertar 30 Consultorios.
 */
@SpringBootTest
class InsertOfficeTestCase {

	private static final Logger log = Logger.getLogger(InsertOfficeTestCase.class);
	
	@Autowired
	private OfficeService officeService;
	
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
	private OfficeDTO officeDTO11;
	private OfficeDTO officeDTO12;
	private OfficeDTO officeDTO13;
	private OfficeDTO officeDTO14;
	private OfficeDTO officeDTO15;
	private OfficeDTO officeDTO16;
	private OfficeDTO officeDTO17;
	private OfficeDTO officeDTO18;
	private OfficeDTO officeDTO19;
	private OfficeDTO officeDTO20;
	private OfficeDTO officeDTO21;
	private OfficeDTO officeDTO22;
	private OfficeDTO officeDTO23;
	private OfficeDTO officeDTO24;
	private OfficeDTO officeDTO25;
	private OfficeDTO officeDTO26;
	private OfficeDTO officeDTO27;
	private OfficeDTO officeDTO28;
	private OfficeDTO officeDTO29;
	private OfficeDTO officeDTO30;
	private Integer quantity;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		officeDTO = new OfficeDTO("Piso 1", 1,"Pediatría","VERDE");
		officeDTO2 = new OfficeDTO("Piso 1", 2,"Pediatría","VERDE");
		officeDTO3 = new OfficeDTO("Piso 1", 3,"Pediatría","VERDE");
		
		officeDTO4 = new OfficeDTO("Piso 1", 4,"Dermatología","VERDE");
		officeDTO5 = new OfficeDTO("Piso 1", 5,"Gatroenterología","VERDE");
		officeDTO6 = new OfficeDTO("Piso 1", 6,"Gatroenterología","VERDE");
		officeDTO7 = new OfficeDTO("Piso 1", 7,"Neumología","VERDE");
		officeDTO8 = new OfficeDTO("Piso 1", 8,"Neumología","VERDE");
		officeDTO9 = new OfficeDTO("Piso 1", 9,"Otorrinolaringología","VERDE");
		officeDTO10 = new OfficeDTO("Piso 1", 10,"Cardiología","VERDE");
		officeDTO11 = new OfficeDTO("Piso 1", 11,"Alergia e Inmunología","VERDE");
		officeDTO12 = new OfficeDTO("Piso 1", 12,"Alergia e Inmunología","VERDE");
		officeDTO13 = new OfficeDTO("Piso 1", 13,"Diabetología","VERDE");
		officeDTO14 = new OfficeDTO("Piso 1", 14,"Psiquiatría","VERDE");
		officeDTO15 = new OfficeDTO("Piso 1", 15,"Psiquiatría","VERDE");
		
		
		officeDTO16 = new OfficeDTO("Piso 2", 16,"Ginecología Y Obstetricia","AMARILLO");
		officeDTO17 = new OfficeDTO("Piso 2", 17,"Ginecología Y Obstetricia","AMARILLO");
		officeDTO18 = new OfficeDTO("Piso 2", 18,"Hematología","AMARILLO");
		officeDTO19 = new OfficeDTO("Piso 2", 19,"Infectología","AMARILLO");
		officeDTO20 = new OfficeDTO("Piso 2", 20,"Ortopedia","AMARILLO");
		officeDTO21 = new OfficeDTO("Piso 2", 21,"Ortopedia","AMARILLO");
		officeDTO22 = new OfficeDTO("Piso 2", 22,"Endocrinología","AMARILLO");
		officeDTO23 = new OfficeDTO("Piso 2", 23,"Endocrinología","AMARILLO");
		
		officeDTO24 = new OfficeDTO("Piso 3", 24,"Nefrología","NARANJA");
		officeDTO25 = new OfficeDTO("Piso 3", 25,"Oncología","NARANJA");
		officeDTO26 = new OfficeDTO("Piso 3", 26,"Oncología","NARANJA");
		officeDTO27 = new OfficeDTO("Piso 3", 27,"Hemoterapia","NARANJA");
		officeDTO28 = new OfficeDTO("Piso 3", 28,"Hemoterapia","NARANJA");
		officeDTO29 = new OfficeDTO("Piso 3", 29,"Diagnóstico por Imágenes","NARANJA");
		officeDTO30 = new OfficeDTO("Piso 3", 30,"Radiología","NARANJA");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testAddOffice() {
		try {
			officeService.addOffice(officeDTO);
			officeService.addOffice(officeDTO2);
			officeService.addOffice(officeDTO3);
			officeService.addOffice(officeDTO4);
			officeService.addOffice(officeDTO5);
			officeService.addOffice(officeDTO6);
			officeService.addOffice(officeDTO7);
			officeService.addOffice(officeDTO8);
			officeService.addOffice(officeDTO9);
			officeService.addOffice(officeDTO10);
			officeService.addOffice(officeDTO11);
			officeService.addOffice(officeDTO12);
			officeService.addOffice(officeDTO13);
			officeService.addOffice(officeDTO14);
			officeService.addOffice(officeDTO15);
			officeService.addOffice(officeDTO16);
			officeService.addOffice(officeDTO17);
			officeService.addOffice(officeDTO18);
			officeService.addOffice(officeDTO19);
			officeService.addOffice(officeDTO20);
			officeService.addOffice(officeDTO21);
			officeService.addOffice(officeDTO22);
			officeService.addOffice(officeDTO23);
			officeService.addOffice(officeDTO24);
			officeService.addOffice(officeDTO25);
			officeService.addOffice(officeDTO26);
			officeService.addOffice(officeDTO27);
			officeService.addOffice(officeDTO28);
			officeService.addOffice(officeDTO29);
			officeService.addOffice(officeDTO30);
			
			
			quantity = officeService.listOffice().size();
			assertTrue(quantity.equals(30));
		} catch (Exception e) {
			log.debug(e.getCause());
		}
	}

}
