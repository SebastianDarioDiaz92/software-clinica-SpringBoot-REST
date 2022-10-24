/**
 * 
 */
package ar.edu.unju.fi.clinica.Service.Imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.clinica.DTO.OfficeDTO;
import ar.edu.unju.fi.clinica.Mapper.Mapper;
import ar.edu.unju.fi.clinica.Repository.OfficeRepository;
import ar.edu.unju.fi.clinica.Service.OfficeService;

/**
 * @author Diaz, Sebastián Darío
 * Clase de implementación del servicio OfficeService.
 */
@Service
public class OfficeServiceImp implements OfficeService {
	private static final Logger log = Logger.getLogger(OfficeServiceImp.class);
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@Override
	public void addOffice(OfficeDTO officeDTO) {
		try {
			if(officeRepository.findByIdOffice(officeDTO.getIdOffice()) != null) {
				log.debug("Ya se encuentra registrado un Consultorio con este número: " + officeDTO.getNumberOffice());
			}else {
				officeRepository.save(Mapper.mapToOffice(officeDTO));
				log.info("Se registró correctamente: " + officeDTO);
			}
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public void updateOffice(OfficeDTO officeDTOOriginal, OfficeDTO officeDTOUpdated) {
		try {
			OfficeDTO officeAux = new OfficeDTO();
			officeAux = Mapper.mapToOfficeDTO(officeRepository.findByNumberOffice(officeDTOOriginal.getNumberOffice()));
			officeAux.setDescriptionOffice(officeDTOUpdated.getDescriptionOffice());
			officeAux.setFloor(officeDTOUpdated.getDescriptionOffice());
			officeAux.setNumberOffice(officeDTOUpdated.getNumberOffice());
			officeAux.setVisualIdentifier(officeDTOUpdated.getVisualIdentifier());
			officeRepository.save(Mapper.mapToOffice(officeAux));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public void deleteOffice(OfficeDTO officeDTO) {
		try {
			officeRepository.delete(Mapper.mapToOffice(officeDTO));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public List<OfficeDTO> listOffice() {
		return Mapper.mapTotListOfficeDTO(officeRepository.findAll());
	}

	@Override
	public OfficeDTO findByNumberOffice(Integer numberOffice) {
		return Mapper.mapToOfficeDTO(officeRepository.findByNumberOffice(numberOffice));
	}

	@Override
	public List<OfficeDTO> findOfficeByDescription(String descriptionOffice) {
		return Mapper.mapTotListOfficeDTO(officeRepository.findByDescriptionOffice(descriptionOffice));
	}

	@Override
	public List<OfficeDTO> findOfficeByFloor(String floorOffice) {
		return Mapper.mapTotListOfficeDTO(officeRepository.findByFloor(floorOffice));
	}

	@Override
	public OfficeDTO findOfficeById(Long idOffice) {
		return Mapper.mapToOfficeDTO(officeRepository.findByIdOffice(idOffice));
	}

	@Override
	public void deleteOfficeById(Long idOffice) {
		try {
			officeRepository.deleteById(idOffice);
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public OfficeDTO addOfficeDTO(OfficeDTO officeDTO) {
		OfficeDTO offDto = null;
		try {
			if(officeRepository.findByIdOffice(officeDTO.getIdOffice()) != null) {
				log.debug("Ya se encuentra registrado un Consultorio con este número: " + officeDTO.getNumberOffice());
			}else {
				officeRepository.save(Mapper.mapToOffice(officeDTO));
				log.debug("Se registró correctamente: " + officeDTO);
				offDto = officeDTO;
			}
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
		return offDto;
	}
}
