/**
 * 
 */
package ar.edu.unju.fi.clinica.Service.Imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.clinica.DTO.MedicalPlanDTO;
import ar.edu.unju.fi.clinica.Entity.MedicalPlan;
import ar.edu.unju.fi.clinica.Mapper.Mapper;
import ar.edu.unju.fi.clinica.Repository.MedicalPlanRepository;
import ar.edu.unju.fi.clinica.Service.MedicalPlanService;

/**
 * @author Diaz, Sebastián Darío
 * Clase de implementación del servicio MedicalPlanService.
 */
@Service
public class MedicalPlanServiceImp implements MedicalPlanService {
	private static Logger log = Logger.getLogger(MedicalPlanServiceImp.class);

	@Autowired
	private MedicalPlanRepository medicalPlanRepository;

	@Override
	public void addMedicalPlan(MedicalPlanDTO medicalPlanDTO) {
		try {
			if (medicalPlanRepository.findByBusinessNameMedicalPlan(medicalPlanDTO.getBusinessNameMedicalPlan()) != null) {
				log.debug("Ya se encuentra registrado un Plan Medico con este nombre: "
						+ medicalPlanDTO.getBusinessNameMedicalPlan());
			} else {
				medicalPlanRepository.save(Mapper.mapToMedicalPlan(medicalPlanDTO));
				log.info("Se agregó: " + medicalPlanDTO.getBusinessNameMedicalPlan());
			}
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}
	
	@Override
	public void deleteMedicalPlan(MedicalPlanDTO medicalPlanDTO) {
		try {
			medicalPlanRepository.delete(Mapper.mapToMedicalPlan(medicalPlanDTO));
		} catch (Exception e) {
			log.info(e.getStackTrace());
		}
	}

	@Override
	public MedicalPlanDTO findMedicalPlanByBusinessName(String businessName) {
		return Mapper.mapToMedicalPlanDTO(medicalPlanRepository.findByBusinessNameMedicalPlan(businessName));
	}

	@Override
	public Integer countMedicalPlan() {
		return medicalPlanRepository.findAll().size();
	}

	@Override
	public void updateMedicalPlan(MedicalPlanDTO medicalPlanDTOOriginal, MedicalPlanDTO medicalPlanDTOUpdated) {
		try {
			MedicalPlanDTO mpAux = new MedicalPlanDTO();
			mpAux = Mapper.mapToMedicalPlanDTO(medicalPlanRepository.findByIdMedicalPlan(medicalPlanDTOOriginal.getIdMedicalPlan()));
			mpAux.setAddressMedicalPlan(medicalPlanDTOUpdated.getAddressMedicalPlan());
			mpAux.setBusinessNameMedicalPlan(medicalPlanDTOUpdated.getBusinessNameMedicalPlan());
			mpAux.setPhoneNumberMedicalPlan(medicalPlanDTOUpdated.getPhoneNumberMedicalPlan());
			medicalPlanRepository.save(Mapper.mapToMedicalPlan(mpAux));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public List<MedicalPlanDTO> getAllMedicalPlan() {
		return Mapper.mapToListMedicalPlanDTO(medicalPlanRepository.findAll());
	}

	@Override
	public MedicalPlanDTO findMedicalPlanById(Long idMedicalPlan) {
		return Mapper.mapToMedicalPlanDTO(medicalPlanRepository.findByIdMedicalPlan(idMedicalPlan));
	}

	@Override
	public void deleteMedicalPlanById(Long idMedicalPlan) {
		try {
			medicalPlanRepository.deleteById(idMedicalPlan);
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}	
	}

	@Override
	public MedicalPlanDTO addMedicalPlanDTO(MedicalPlanDTO medicalPlanDTO) {
		MedicalPlan medicalPlan = medicalPlanRepository.save(Mapper.mapToMedicalPlan(medicalPlanDTO));
		return Mapper.mapToMedicalPlanDTO(medicalPlan);
	}
}
