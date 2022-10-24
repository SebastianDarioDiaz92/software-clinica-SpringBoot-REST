/**
 * 
 */
package ar.edu.unju.fi.clinica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unju.fi.clinica.DTO.RoleDTO;
import ar.edu.unju.fi.clinica.Entity.Role;
import ar.edu.unju.fi.clinica.Service.RoleService;
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
@RequestMapping("/api/v1/rol")
public class RolController {

	@Autowired
	private RoleService roleService;
	
	@Operation(summary = "Agregar Rol.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se agregó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Role.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PostMapping("/add")
	public RoleDTO addRol(@RequestBody RoleDTO rolDTO) {
		roleService.addRol(rolDTO);
		return rolDTO;
	}
	
	@Operation(summary = "Listado de Roles.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se listó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Role.class)) }),
			  @ApiResponse(responseCode = "400", description = "Acción Invalida", 
			    content = @Content) })
	@GetMapping("/getAll")
	public List<RoleDTO> listRol(){
		return roleService.listRol();
	}
	
	@Operation(summary = "Buscar Rol por su Descripción.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Rol fué encontrada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Role.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Rol no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Rol no encontrado.", 
			    content = @Content)})
	@GetMapping("/getByDescription/{descriptionRol}")
	public ResponseEntity<RoleDTO> getRoleByDescription(@PathVariable String descriptionRol){
		RoleDTO roleDTO = roleService.findRolByDescription(descriptionRol);
		return ResponseEntity.ok().body(roleDTO);
	}
	
	@Operation(summary = "Actualizar Rol.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se actualizó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Role.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PutMapping("/update/{idRol}")
	public ResponseEntity<RoleDTO> updateRole(@PathVariable Long idRol, @RequestBody RoleDTO roleDTO){
		RoleDTO roleAux = roleService.findRolByID(idRol);
		roleAux.setDescriptionRol(roleDTO.getDescriptionRol());
		
		RoleDTO roleUp = roleService.addRolDTO(roleAux);
		return ResponseEntity.ok().body(roleUp);
	}
	
	@Operation(summary = "Eliminar Rol por su ID.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Rol fué elminado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Role.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Rol no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Rol no encontrado.", 
			    content = @Content)})
	@DeleteMapping("/delete/{idRol}")
	public String deleteRol(@PathVariable Long idRol) {
		roleService.deleteRolByID(idRol);
		return "Eliminado Role con ID = " + idRol;
	}
}
