/**
 * 
 */
package ar.edu.unju.fi.clinica.Service.Imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.clinica.DTO.DoctorDTO;
import ar.edu.unju.fi.clinica.Mapper.Mapper;
import ar.edu.unju.fi.clinica.Repository.DoctorRepository;
import ar.edu.unju.fi.clinica.Service.DoctorService;

/**
 * @author Diaz, Sebastián Darío
 * Clase de implementación del servicio DoctorService.
 */
@Service
public class DoctorServiceImp implements DoctorService {
	private static final Logger log = Logger.getLogger(DoctorServiceImp.class);
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public void addDoctor(DoctorDTO doctorDTO) {
		try {
			if(doctorRepository.findByLicenseNumber(doctorDTO.getLicenseNumber()) != null) {
				log.debug("Ya se encuentra registrado un Doctor con este numero de Licencia: "
						+ doctorDTO.getLicenseNumber());
			}else {
				doctorRepository.save(Mapper.mapToDoctor(doctorDTO));
				log.info("Se agregó correctamente el Doctor : " + doctorDTO);
			}
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}	
	}

	@Override
	public void updateDoctor(DoctorDTO doctorDTOOriginal, DoctorDTO doctorDTOUpdated) {
		try {
			DoctorDTO doctorAux = new DoctorDTO();
			doctorAux = Mapper.mapToDoctorDTO(doctorRepository.findByLicenseNumber(doctorDTOOriginal.getLicenseNumber()));
			doctorAux.setEmail(doctorDTOUpdated.getEmail());
			doctorAux.setFirstName(doctorDTOUpdated.getFirstName());
			doctorAux.setLastName(doctorDTOUpdated.getLastName());
			doctorAux.setLicenseNumber(doctorDTOUpdated.getLicenseNumber());
			doctorAux.setListMedicalPlans(doctorDTOUpdated.getListMedicalPlans());
			doctorAux.setOfficeDoctor(doctorDTOUpdated.getOfficeDoctor());
			doctorAux.setTurn(doctorDTOUpdated.getTurn());
			doctorRepository.save(Mapper.mapToDoctor(doctorAux));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public void deleteDoctor(DoctorDTO doctorDTO) {
		try {
			doctorRepository.delete(Mapper.mapToDoctor(doctorDTO));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}		
	}

	@Override
	public DoctorDTO findDoctorByLicenseNumber(Integer licenseNumber) {
		return Mapper.mapToDoctorDTO(doctorRepository.findByLicenseNumber(licenseNumber));
	}

	@Override
	public List<DoctorDTO> findDoctorsByTurn(String turn) {
		return Mapper.mapToListDoctorDTO(doctorRepository.findByTurn(turn));
	}

	@Override
	public List<DoctorDTO> listDoctor() {
		return Mapper.mapToListDoctorDTO(doctorRepository.findAll());
	}

	@Override
	public DoctorDTO addDoctorDTO(DoctorDTO doctorDTO) {
		DoctorDTO doctorAux = null;
		try {
			if(doctorRepository.findByLicenseNumber(doctorDTO.getLicenseNumber()) != null) {
				log.debug("Ya se encuentra registrado un Doctor con este numero de Licencia: "
						+ doctorDTO.getLicenseNumber());
			}else {
				doctorRepository.save(Mapper.mapToDoctor(doctorDTO));
				log.info("Se agregó correctamente el Doctor : " + doctorDTO);
				doctorAux = doctorDTO;
			}
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
		return doctorAux;
	}

	@Override
	public DoctorDTO findDoctorByID(Long idDoctor) {
		return Mapper.mapToDoctorDTO(doctorRepository.findDoctorById(idDoctor));
	}

	@Override
	public void deleteDoctorByID(Long idDoctor) {
		try {
			doctorRepository.deleteById(idDoctor);
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}			
	}
}
