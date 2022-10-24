/**
 * 
 */
package ar.edu.unju.fi.clinica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unju.fi.clinica.DTO.UserDTO;
import ar.edu.unju.fi.clinica.Entity.Role;
import ar.edu.unju.fi.clinica.Entity.User;
import ar.edu.unju.fi.clinica.Mapper.Mapper;
import ar.edu.unju.fi.clinica.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author Diaz, Sebastián Darío
 *
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Operation(summary = "Agregar Usuario.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se agregó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = User.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PostMapping("/add")
	public UserDTO addUser(@RequestBody UserDTO userDTO, BindingResult result) {
		User existingUser = userService.findUserByEmail(userDTO.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "El E-Mail ingresado ya se encuentra registrado en el sistema.");
        }
        if(result.hasErrors()){
            ResponseEntity.internalServerError().body(userDTO);
        }
		userService.addUser(userDTO);
		return userDTO;
	}
	
	@Operation(summary = "Listado de Usuarios.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se listó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = User.class)) }),
			  @ApiResponse(responseCode = "400", description = "Acción Invalida", 
			    content = @Content) })
	@GetMapping("/getAll")
	public List<UserDTO> listUser(){
		return userService.listUser();
	}
	
	@Operation(summary = "Buscar Usuario por su Nombre de Usuario.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Usuario fué encontrada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = User.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Usuario no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Usuario no encontrado.", 
			    content = @Content)})
	@GetMapping("/getByUserName/{nameUser}")
	public ResponseEntity<UserDTO> getUserByNameUser(@PathVariable String nameUser){
		UserDTO userDTO = userService.findUserByNameUser(nameUser);
		return ResponseEntity.ok().body(userDTO);
	}
	
	@Operation(summary = "Buscar Usuario por su E-Mail.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Usuario fué encontrada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = User.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Usuario no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Usuario no encontrado.", 
			    content = @Content)})
	@GetMapping("/getByEmail/{mailUser}")
	public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String mailUser){
		UserDTO userDTO = Mapper.mapToUserDTO(userService.findUserByEmail(mailUser));
		return ResponseEntity.ok().body(userDTO);
	}
	
	@Operation(summary = "Actualizar Usuario.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se actualizó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = User.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PutMapping("/update/{idUser}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable String mailUser, @RequestBody UserDTO userDTOUpdated){
		UserDTO userAux = Mapper.mapToUserDTO(userService.findUserByEmail(mailUser));
		userAux.setEmail(userDTOUpdated.getEmail());
		userAux.setFirstName(userDTOUpdated.getFirstName());
		userAux.setLastName(userDTOUpdated.getLastName());
		userAux.setNameUser(userDTOUpdated.getNameUser());
		userAux.setPassword(passwordEncoder.encode(userDTOUpdated.getPassword()));
		
		UserDTO userUp = userService.addUserDTO(userAux);
		return ResponseEntity.ok().body(userUp);
	}
	
	@Operation(summary = "Eliminar Usuario por su ID.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Usuario fué elminado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Role.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Usuario no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Usuario no encontrado.", 
			    content = @Content)})
	@DeleteMapping("/delete/{idUser}")
	public String deleteUser(@PathVariable Long idUser) {
		userService.deleteUserByID(idUser);
		return "Eliminado con éxito Usuario con ID = " + idUser;
	}
}
