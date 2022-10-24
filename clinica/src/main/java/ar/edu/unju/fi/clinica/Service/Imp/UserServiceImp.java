/**
 * 
 */
package ar.edu.unju.fi.clinica.Service.Imp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.clinica.DTO.UserDTO;
import ar.edu.unju.fi.clinica.Entity.Role;
import ar.edu.unju.fi.clinica.Entity.User;
import ar.edu.unju.fi.clinica.Mapper.Mapper;
import ar.edu.unju.fi.clinica.Repository.RoleRepository;
import ar.edu.unju.fi.clinica.Repository.UserRepository;
import ar.edu.unju.fi.clinica.Service.MailService;
import ar.edu.unju.fi.clinica.Service.UserService;

/**
 * @author Diaz, Sebastián Darío
 * Clase de implementación del servicio UserService.
 */
@Service
public class UserServiceImp implements UserService {
	private static Logger log = Logger.getLogger(UserServiceImp.class);

	@Autowired
	private MailService mailService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
    private RoleRepository roleRepository;
	
    private PasswordEncoder passwordEncoder;
    
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
	@Override
	public void addUser(UserDTO userDTO) {
		User existingUser = userRepository.findUserByEmail(userDTO.getEmail());
		try {
			if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
				log.debug("El E-Mail ingresado ya se encuentra registrado en el sistema.");
			}else {
				User user = new User();
				user.setNameUser(userDTO.getNameUser());
				user.setFirstName(userDTO.getFirstName());
				user.setLastName(userDTO.getLastName());
		        user.setEmail(userDTO.getEmail());
		        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		        
		        Role role = roleRepository.findByDescriptionRol("ROLE_"+userDTO.getRoleUser());
		        if(role == null){
		            role = checkRoleExist();
		        }
		        user.setRoles(Arrays.asList(role));
		        userRepository.save(user);
		        mailService.sendMail("emailtesterapi.2022@gmail.com", user.getEmail(), "Registro Exitoso", bodyEmail(Mapper.mapToUserDTO(user)));
			}
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
		}
	}

	private String bodyEmail(UserDTO userTo) {
		return "Bienvenido Sr.: " + userTo.getFirstName()+ " " +userTo.getLastName() + " , se ha registrado exitosamente en nuestra comunidad.";
	}
	
	private Role checkRoleExist(){
        Role role = new Role();
        role.setDescriptionRol("ROLE_ADMINISTRATOR");
        return roleRepository.save(role);
    }
	
	@Override
	public void updateUser(UserDTO userDTOOriginal, UserDTO userDTOUpdated) {
		try {
			UserDTO userAux = new UserDTO();
			userAux = Mapper.mapToUserDTO(userRepository.findUserByEmail(userDTOOriginal.getEmail()));
			userAux.setEmail(userDTOUpdated.getEmail());
			userAux.setFirstName(userDTOUpdated.getFirstName());
			userAux.setLastName(userDTOUpdated.getLastName());
			userAux.setNameUser(userDTOUpdated.getNameUser());
			userAux.setPassword(passwordEncoder.encode(userDTOUpdated.getPassword()));
			userRepository.save(Mapper.mapToUser(userAux));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public void deleteUser(UserDTO userDTO) {
		try {
			userRepository.delete(Mapper.mapToUser(userDTO));
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public UserDTO findUserByID(Long idUser) {
		return null;
	}

	@Override
	public UserDTO findUserByNameUser(String nameUser) {
		return Mapper.mapToUserDTO(userRepository.findByNameUser(nameUser));
	}

	@Override
	public List<UserDTO> listUser() {
		List<User> users = userRepository.findAll();
        return users.stream().map((user) -> Mapper.mapToUserDTO(user)).collect(Collectors.toList());
	}

	@Override
	public void deleteUserByID(Long idUser) {
		try {
			userRepository.deleteById(idUser);
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public List<UserDTO> listUsersAsc() {
		return Mapper.mapToListUserDTO(userRepository.findAll(Sort.by("lastName").ascending()));
	}

	@Override
	public UserDTO addUserDTO(UserDTO userDTO) {
		UserDTO userDTOAux = null;
		User existingUser = userRepository.findUserByEmail(userDTO.getEmail());
		try {
			if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
				log.debug("El E-Mail ingresado ya se encuentra registrado en el sistema.");
			}
			else {
				User user = new User();
				user.setNameUser(userDTO.getNameUser());
				user.setFirstName(userDTO.getFirstName());
				user.setLastName(userDTO.getLastName());
		        user.setEmail(userDTO.getEmail());
		        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

		        Role role = roleRepository.findByDescriptionRol("ROLE_ADMINISTRATOR");
		        if(role == null){
		            role = checkRoleExist();
		        }
		        user.setRoles(Arrays.asList(role));
		        userRepository.save(user);
		        userDTOAux = Mapper.mapToUserDTO(user);
		        mailService.sendMail("emailtesterapi.2022@gmail.com", user.getEmail(), "Registro Exitoso", bodyEmail(Mapper.mapToUserDTO(user)));
			}
		} catch (Exception e) {
			log.debug(e.getStackTrace());
		}
		return userDTOAux;
	}
}
