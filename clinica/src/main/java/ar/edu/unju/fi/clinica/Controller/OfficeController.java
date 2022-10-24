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

import ar.edu.unju.fi.clinica.DTO.OfficeDTO;
import ar.edu.unju.fi.clinica.Entity.Office;
import ar.edu.unju.fi.clinica.Service.OfficeService;
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
@RequestMapping("/api/v1/office")
public class OfficeController {

	@Autowired
	private OfficeService officeService;
	
	@Operation(summary = "Agregar Consultorio.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se agregó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Office.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PostMapping()
	public OfficeDTO addOffice(@RequestBody OfficeDTO officeDTO) {
		officeService.addOffice(officeDTO);
		return officeDTO;
	}
	
	@Operation(summary = "Listado de Consultorios.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se listó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Office.class)) }),
			  @ApiResponse(responseCode = "400", description = "Acción Invalida", 
			    content = @Content) })
	@GetMapping("/getAll")
	public List<OfficeDTO> listOffice(){
		return officeService.listOffice();
	}

	@Operation(summary = "Buscar Consultorio por ID.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Consultorio fué encontrada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Office.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Consultorio no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Consultorio no encontrado.", 
			    content = @Content)})
	@GetMapping("/getById/{idOffice}")
	public ResponseEntity<OfficeDTO> findOfficeById(@PathVariable Long idOffice) {
		OfficeDTO officeDTO = officeService.findOfficeById(idOffice);
		return ResponseEntity.ok().body(officeDTO);
	}
	
	@Operation(summary = "Buscar Consultorio por Número.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Consultorio fué encontrada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Office.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Consultorio no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Consultorio no encontrado.", 
			    content = @Content)})
	@GetMapping("/getByNumber/{numberOffice}")
	public ResponseEntity<OfficeDTO> findOfficeByNumberOffice(@PathVariable Integer numberOffice) {
		OfficeDTO officeDTO = officeService.findByNumberOffice(numberOffice);
		return ResponseEntity.ok().body(officeDTO);
	}
	
	@Operation(summary = "Buscar Consultorio por Descripción.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Consultorio fué encontrada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Office.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Consultorio no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Consultorio no encontrado.", 
			    content = @Content)})
	@GetMapping("/getByDescription/{descriptionOffice}")
	public List<OfficeDTO> listOfficeByDescription(@PathVariable String descriptionOffice){
		return officeService.findOfficeByDescription(descriptionOffice);
	}
	
	@Operation(summary = "Listado de Consultorios por Piso.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se listó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Office.class)) }),
			  @ApiResponse(responseCode = "400", description = "Acción Invalida", 
			    content = @Content) })
	@GetMapping("/getByFloor/{floorOffice}")
	public List<OfficeDTO> listOfficeByFloor(@PathVariable String dfloorOffice){
		return officeService.findOfficeByFloor(dfloorOffice);
	}
	
	@Operation(summary = "Actualizar Consultorio.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se actualizó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Office.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PutMapping("/update/{idOffice}")
	public ResponseEntity<OfficeDTO> updateOffice(@PathVariable Long idOffice, @RequestBody OfficeDTO officeDTOUpdated){
		OfficeDTO officeAux = officeService.findOfficeById(idOffice);
		officeAux.setDescriptionOffice(officeDTOUpdated.getDescriptionOffice());
		officeAux.setFloor(officeDTOUpdated.getFloor());
		officeAux.setNumberOffice(officeDTOUpdated.getNumberOffice());
		officeAux.setVisualIdentifier(officeDTOUpdated.getVisualIdentifier());
		
		OfficeDTO officeUp = officeService.addOfficeDTO(officeAux);
		return ResponseEntity.ok().body(officeUp);
	}
	
	@Operation(summary = "Eliminar Consultorio.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Consultorio fué elminada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Office.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Consultorio no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Consultorio no encontrado.", 
			    content = @Content)})
	@DeleteMapping("/delete/{idOffice}")
	public String deleteOffice(@PathVariable Long idOffice) {
		officeService.deleteOfficeById(idOffice);
		return "Se eliminó con éxito el Consultorio con ID = " + idOffice;
	}
}
