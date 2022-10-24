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

import ar.edu.unju.fi.clinica.DTO.MedicalPlanDTO;
import ar.edu.unju.fi.clinica.Entity.MedicalPlan;
import ar.edu.unju.fi.clinica.Service.MedicalPlanService;
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
@RequestMapping("/api/v1/medicalPlan")
public class MedicalPlanController {

	@Autowired
	private MedicalPlanService medicalPlanService;
	
	@Operation(summary = "Agregar Obra Social.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se agregó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = MedicalPlan.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PostMapping("/add")
	public MedicalPlanDTO addMedicalPlan(@RequestBody MedicalPlanDTO medicalPlanDTO) {
		medicalPlanService.addMedicalPlan(medicalPlanDTO);
		return medicalPlanDTO;
	}
	
	@Operation(summary = "Listado de Obras Sociales.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se listó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = MedicalPlan.class)) }),
			  @ApiResponse(responseCode = "400", description = "Acción Invalida", 
			    content = @Content) })
	@GetMapping("/getAll")
	public List<MedicalPlanDTO> listMedicalPlan(){
		return medicalPlanService.getAllMedicalPlan();
	}
	
	@Operation(summary = "Buscar Obra Social por nombre empresarial.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Obra Social fué encontrada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = MedicalPlan.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Obra Social no encontrada.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Obra Social no encontrada.", 
			    content = @Content)})
	@GetMapping("getByName/{businessName}")
	public ResponseEntity<MedicalPlanDTO> findMedicalPlanByBusinessName(@PathVariable String businessName) {
		MedicalPlanDTO medicalPlanDTO = medicalPlanService.findMedicalPlanByBusinessName(businessName);
		return ResponseEntity.ok().body(medicalPlanDTO);
	}
	
	@Operation(summary = "Buscar Obra Social por ID.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Obra Social fué encontrada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = MedicalPlan.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Obra Social no encontrada.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Obra Social no encontrada.", 
			    content = @Content)})
	@GetMapping("/getById/{idMedicalPlan}")
	public ResponseEntity<MedicalPlanDTO> findMedicalPlanById(@PathVariable Long idMedicalPlan) {
		MedicalPlanDTO medicalPlanDTO = medicalPlanService.findMedicalPlanById(idMedicalPlan);
		return ResponseEntity.ok().body(medicalPlanDTO);
	}
	
	@Operation(summary = "Actualizar ObraSocial.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se actualizó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = MedicalPlan.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PutMapping("/update/{idMedicalPlan}")
	public ResponseEntity<MedicalPlanDTO> updateMedicalPlan(@PathVariable Long idMedicalPlan, @RequestBody MedicalPlanDTO medicalPlanDTOUpdated) {
		MedicalPlanDTO medicalPlanAux = medicalPlanService.findMedicalPlanById(idMedicalPlan);
		medicalPlanAux.setAddressMedicalPlan(medicalPlanDTOUpdated.getAddressMedicalPlan());
		medicalPlanAux.setBusinessNameMedicalPlan(medicalPlanDTOUpdated.getBusinessNameMedicalPlan());
		medicalPlanAux.setPhoneNumberMedicalPlan(medicalPlanDTOUpdated.getPhoneNumberMedicalPlan());
		
		MedicalPlanDTO medicalPlanDTOUpdate = medicalPlanService.addMedicalPlanDTO(medicalPlanAux);
		return ResponseEntity.ok().body(medicalPlanDTOUpdate);
	}
	
	@Operation(summary = "Eliminar Obra Social por su ID.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Obra Social fué elminada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = MedicalPlan.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Obra Social no encontrada.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Obra Social no encontrada.", 
			    content = @Content)})
	@DeleteMapping("/delete/{idMedicalPlan}")
	public String deleteMedicalPlan(@PathVariable Long idMedicalPlan) {
		medicalPlanService.deleteMedicalPlanById(idMedicalPlan);
		return "Se eliminó exitosamente el Rol con ID = " + idMedicalPlan;
	}	
}
