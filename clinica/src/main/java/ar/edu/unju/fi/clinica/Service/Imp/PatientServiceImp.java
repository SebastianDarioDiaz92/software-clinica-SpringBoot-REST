/**
 * 
 */
package ar.edu.unju.fi.clinica.Service.Imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.clinica.DTO.PatientDTO;
import ar.edu.unju.fi.clinica.Mapper.Mapper;
import ar.edu.unju.fi.clinica.Repository.PatientRepository;
import ar.edu.unju.fi.clinica.Service.PatientService;

/**
 * @author Diaz, Sebastián Darío
 * Clase de implementación del servicio PatientService.
 */
@Service
public class PatientServiceImp implements PatientService{
	private static final Logger log = Logger.getLogger(PatientServiceImp.class);
	
	@Autowired
	private PatientRepository patientRepository;
		
	@Override
	public void addPatient(PatientDTO patientDTO) {
		try {
			if(patientRepository.findByDniPatient(patientDTO.getDniPatient()) != null){
				log.debug("Ya se encuentra registrado un Paciente con este D.N.I: " + patientDTO.getDniPatient());
			}else {
				patientRepository.save(Mapper.mapToPatient(patientDTO));
				log.info("Se registró correctamente el Paciente: " + patientDTO);
			}
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
		}
	}

	@Override
	public void updatePatient(PatientDTO patientDTOOriginal, PatientDTO patientDTOUpdated) {
		try {
			PatientDTO patientAux = new PatientDTO();
			patientAux = Mapper.mapToPatientDTO(patientRepository.findByDniPatient(patientDTOOriginal.getDniPatient()));
			patientAux.setAddressPatient(patientDTOUpdated.getAddressPatient());
			patientAux.setDniPatient(patientDTOUpdated.getDniPatient());
			patientAux.setEmail(patientDTOUpdated.getEmail());
			patientAux.setFirstName(patientAux.getFirstName());
			patientAux.setLastName(patientDTOUpdated.getLastName());
			patientAux.setMedicalPlan(patientDTOUpdated.getMedicalPlan());
			patientAux.setPhoneNumberPatient(patientDTOUpdated.getPhoneNumberPatient());
			patientRepository.save(Mapper.mapToPatient(patientAux));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public void deletePatient(PatientDTO patientDTO) {
		try {
			patientRepository.delete(Mapper.mapToPatient(patientDTO));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public PatientDTO findPatientByDNI(Integer dniPatient) {
		return Mapper.mapToPatientDTO(patientRepository.findByDniPatient(dniPatient));
	}

	@Override
	public List<PatientDTO> listPatient() {
		return Mapper.mapToListPatientDTO(patientRepository.findAll());
	}

	@Override
	public void deletePatientById(Long idPatient) {
		try {
			patientRepository.deleteById(idPatient);
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
		
	}

	@Override
	public PatientDTO addPatientDTO(PatientDTO patientDTO) {
		PatientDTO paDto = null;
		try {
			if(patientRepository.findByDniPatient(patientDTO.getDniPatient()) != null){
				log.debug("Ya se encuentra registrado un Paciente con este D.N.I: " + patientDTO.getDniPatient());
			}else {
				patientRepository.save(Mapper.mapToPatient(patientDTO));
				log.info("Se registró correctamente el Paciente: " + patientDTO);
				paDto = patientDTO;
			}
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
		return paDto;
	}

	@Override
	public PatientDTO findPatientByID(Long idPatient) {
		return Mapper.mapToPatientDTO(patientRepository.findPatientById(idPatient));
	}
}
