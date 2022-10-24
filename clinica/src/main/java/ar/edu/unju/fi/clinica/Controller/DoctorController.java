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

import ar.edu.unju.fi.clinica.DTO.DoctorDTO;
import ar.edu.unju.fi.clinica.Entity.Doctor;
import ar.edu.unju.fi.clinica.Service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author Diaz, Sebastián Darío
 * Controladores REST, Documentación disponible en: /swagger-ui/index.html
 */
@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Operation(summary = "Agregar Doctor")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Se agregó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Doctor.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PostMapping("/add")
	public DoctorDTO addDoctor(@RequestBody DoctorDTO doctorDTO) {
		doctorService.addDoctor(doctorDTO);
		return doctorDTO;
	}
	
	@Operation(summary = "Listado de Doctores")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se listó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Doctor.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@GetMapping("/getAll")
	public List<DoctorDTO> listDoctor(){
		return doctorService.listDoctor();
	}
	
	@Operation(summary = "Buscar Doctor por su número de licencia.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Ok, Doctor fué encontrado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Doctor.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Doctor no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Doctor no encontrado.", 
			    content = @Content)})
	@GetMapping("/getByLicense/{licenseNumber}")
	public ResponseEntity<DoctorDTO> findDoctorByLicenseNumber(@PathVariable Integer licenseNumber) {
		DoctorDTO doctorDTO = doctorService.findDoctorByLicenseNumber(licenseNumber);
		return ResponseEntity.ok().body(doctorDTO);
	}
	
	@Operation(summary = "Listado de Doctores filtrado por turno.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se listó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Doctor.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@GetMapping("/getByTurn/{turn}")
	public List<DoctorDTO> listDoctorByTurn(@PathVariable String turn){
		return doctorService.findDoctorsByTurn(turn);
	}
	
	@Operation(summary = "Actualizar Doctor.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se actualizó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Doctor.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PutMapping("/update/{idDoctor}")
	public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Integer licenseNumber,@RequestBody DoctorDTO doctorDTOUpdated){
		DoctorDTO doctorAux = doctorService.findDoctorByLicenseNumber(licenseNumber);
		doctorAux.setEmail(doctorDTOUpdated.getEmail());
		doctorAux.setFirstName(doctorDTOUpdated.getFirstName());
		doctorAux.setLastName(doctorDTOUpdated.getLastName());
		doctorAux.setLicenseNumber(doctorDTOUpdated.getLicenseNumber());
		doctorAux.setListMedicalPlans(doctorDTOUpdated.getListMedicalPlans());
		doctorAux.setOfficeDoctor(doctorDTOUpdated.getOfficeDoctor());
		doctorAux.setTurn(doctorDTOUpdated.getTurn());
		
		DoctorDTO doctorUp = doctorService.addDoctorDTO(doctorAux);
		return ResponseEntity.ok().body(doctorUp);
	}
	
	@Operation(summary = "Eliminar Doctor por su ID.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Doctor fué elminado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Doctor.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Doctor no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Doctor no encontrado.", 
			    content = @Content)})
	@DeleteMapping("/delete/{idDoctor}")
	public String deleteDoctor(@PathVariable Long idDoctor) {
		doctorService.deleteDoctorByID(idDoctor);
		return "Se eliminó exitosamente el Doctor con ID = " + idDoctor;
	}

}
