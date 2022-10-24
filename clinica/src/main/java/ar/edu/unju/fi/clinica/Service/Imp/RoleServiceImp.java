/**
 * 
 */
package ar.edu.unju.fi.clinica.Service.Imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.clinica.DTO.RoleDTO;
import ar.edu.unju.fi.clinica.Mapper.Mapper;
import ar.edu.unju.fi.clinica.Repository.RoleRepository;
import ar.edu.unju.fi.clinica.Service.RoleService;

/**
 * @author Diaz, Sebastián Darío
 * Clase de implementación del servicio RoleService.
 */
@Service
public class RoleServiceImp implements RoleService{
	private static final Logger log = Logger.getLogger(RoleServiceImp.class);
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void addRol(RoleDTO rolDTO) {
		try {
			roleRepository.save(Mapper.mapToRol(rolDTO));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public void updateRol(RoleDTO roleDTOOriginal, RoleDTO roleDTOUpdated) {
		try {
			RoleDTO roleAux = new RoleDTO();
			roleAux = Mapper.mapToRolDTO(roleRepository.findByDescriptionRol(roleDTOOriginal.getDescriptionRol()));
			roleAux.setDescriptionRol(roleDTOUpdated.getDescriptionRol());
			roleRepository.save(Mapper.mapToRol(roleAux));
			log.info("Se actualizó correctamente: " + roleAux);
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public void deleteRol(RoleDTO rolDTO) {
		try {
			roleRepository.delete(Mapper.mapToRol(rolDTO));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public RoleDTO findRolByID(Long idRol) {
		return Mapper.mapToRolDTO(roleRepository.findByIdRol(idRol));
	}
	
	@Override
	public RoleDTO findRolByDescription(String descriptionRol) {
		return Mapper.mapToRolDTO(roleRepository.findByDescriptionRol(descriptionRol));
	}
	
	@Override
	public List<RoleDTO> listRol() {
		return Mapper.mapToListRolDTO(roleRepository.findAll());
	}

	@Override
	public void deleteRolByID(Long idRol) {
		roleRepository.deleteById(idRol);
	}

	@Override
	public RoleDTO addRolDTO(RoleDTO roleDTO) {
		RoleDTO role = null;
		try {
			roleRepository.save(Mapper.mapToRol(roleDTO));
			role=roleDTO;
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
		return role;
	}
}
