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

import ar.edu.unju.fi.clinica.DTO.DoctorDTO;
import ar.edu.unju.fi.clinica.DTO.MeetingDTO;
import ar.edu.unju.fi.clinica.DTO.PatientDTO;
import ar.edu.unju.fi.clinica.Service.DoctorService;
import ar.edu.unju.fi.clinica.Service.MeetingService;
import ar.edu.unju.fi.clinica.Service.PatientService;
import ar.edu.unju.fi.clinica.Util.FormatLocalDate;

/**
 * @author Diaz, Sebastián Darío
 * Test Insertar 2 Turnos.
 */
@SpringBootTest
class InsertMeetingDTOTestCase {

	private static Logger log = Logger.getLogger(InsertMeetingDTOTestCase.class);
	
	@Autowired
	private MeetingService meetingService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;

	private PatientDTO patient1;
	private PatientDTO patient2;
	private DoctorDTO doctor1;
	private DoctorDTO doctor2;
	private MeetingDTO meetingDTO;
	private MeetingDTO meetingDTO2;
	private Integer meetingCount;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		meetingCount = meetingService.listMeeting().size();
		patient1 = patientService.findPatientByDNI(11111111);
		patient2 = patientService.findPatientByDNI(22222222);
		doctor1 = doctorService.findDoctorByLicenseNumber(1212);
		doctor2 = doctorService.findDoctorByLicenseNumber(1313);
		meetingDTO = new MeetingDTO(FormatLocalDate.formatterStringToLocalDateTime("14-09-2022 11:00"),FormatLocalDate.formatterStringToLocalDateTime("14-09-2022 11:30") , doctor1, patient1);
		meetingDTO2 = new MeetingDTO(FormatLocalDate.formatterStringToLocalDateTime("14-09-2022 11:30"),FormatLocalDate.formatterStringToLocalDateTime("14-09-2022 12:00") , doctor2, patient2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		patient1 = null;
		doctor1 = null;
		patient2 = null;
		doctor2 = null;
		meetingDTO = null;
		meetingDTO2 = null;
		meetingCount = null;
	}

	@Test
	void testInsertMeeting() {
		try {
			meetingService.addMeeting(meetingDTO);
			meetingService.addMeeting(meetingDTO2);
			assertTrue(meetingCount+2 == meetingService.listMeeting().size());

		} catch (Exception e) {
			log.debug(e.getCause());
		}
	}
}
