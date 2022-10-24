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

import ar.edu.unju.fi.clinica.DTO.PatientDTO;
import ar.edu.unju.fi.clinica.Entity.Patient;
import ar.edu.unju.fi.clinica.Service.PatientService;
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
@RequestMapping("/api/v1/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@Operation(summary = "Agregar Paciente.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se agregó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Patient.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PostMapping("/add")
	public PatientDTO addPatient(@RequestBody PatientDTO patientDTO) {
		patientService.addPatient(patientDTO);
		return patientDTO;
	}
	
	@Operation(summary = "Listado de Pacientes.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se listó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Patient.class)) }),
			  @ApiResponse(responseCode = "400", description = "Acción Invalida", 
			    content = @Content) })
	@GetMapping("/getAll")
	public List<PatientDTO> listPatient(){
		return patientService.listPatient();
	}
	
	@Operation(summary = "Buscar Paciente por su D.N.I.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Paciente fué encontrado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Patient.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Paciente no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Paciente no encontrado.", 
			    content = @Content)})
	@GetMapping("/getByDNI/{dniPatient}")
	public ResponseEntity<PatientDTO> getPatientByDNI(@PathVariable Integer dniPatient) {
		PatientDTO patientDTO = patientService.findPatientByDNI(dniPatient);
		return ResponseEntity.ok().body(patientDTO);
	}
	
	@Operation(summary = "Actualizar Paciente.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se actualizó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Patient.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PutMapping("/update/{idPatient}")
	public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long idMedicalPlan, @RequestBody PatientDTO patientDTOUpdated){
		PatientDTO patientAux = patientService.findPatientByID(idMedicalPlan);
		patientAux.setAddressPatient(patientDTOUpdated.getAddressPatient());
		patientAux.setDniPatient(patientDTOUpdated.getDniPatient());
		patientAux.setEmail(patientDTOUpdated.getEmail());
		patientAux.setFirstName(patientDTOUpdated.getFirstName());
		patientAux.setLastName(patientDTOUpdated.getLastName());
		patientAux.setMedicalPlan(patientDTOUpdated.getMedicalPlan());
		patientAux.setPhoneNumberPatient(patientDTOUpdated.getPhoneNumberPatient());
		
		PatientDTO patientUp = patientService.addPatientDTO(patientAux);
		return ResponseEntity.ok().body(patientUp);	
	}
	
	@Operation(summary = "Eliminar Paciente por su ID.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Paciente fué elminado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Patient.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Paciente no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Paciente no encontrado.", 
			    content = @Content)})
	@DeleteMapping("/delete/{idPatient}")
	public String delete(@PathVariable Long idPatient) {
		patientService.deletePatientById(idPatient);
		return "Se eliminó exitosamente el Paciente con ID = " + idPatient;
	}
}
