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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unju.fi.clinica.DTO.MeetingDTO;
import ar.edu.unju.fi.clinica.Entity.Meeting;
import ar.edu.unju.fi.clinica.Service.MeetingService;
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
@RequestMapping("/api/v1/meeting")
public class MeetingController {

	@Autowired
	private MeetingService meetingService;
	
	@Operation(summary = "Agregar Turno.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se agregó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Meeting.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetros Inválidos.", 
			    content = @Content)})
	@PostMapping("/add")
	public MeetingDTO addMeeting(@RequestBody MeetingDTO meetingDTO) {
		meetingService.addMeeting(meetingDTO);
		return meetingDTO;
	}
	
	@Operation(summary = "Listado de Turnos.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Se listó correctamente.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Meeting.class)) }),
			  @ApiResponse(responseCode = "400", description = "Acción Invalida", 
			    content = @Content) })
	@GetMapping("/getAll")
	public List<Meeting> listMeeting(){
		return meetingService.listMeeting();
	}
	
	@Operation(summary = "Buscar Turno por ID.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Turno fué encontrado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Meeting.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Turno no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Turno no encontrado.", 
			    content = @Content)})
	@GetMapping("/getByID/{idMeeting}")
	public ResponseEntity<MeetingDTO> getMeetingById(@PathVariable Long idMeeting) {
		MeetingDTO meetingDTO = meetingService.findMeetingById(idMeeting);
		return ResponseEntity.ok().body(meetingDTO);
	}
	
	@Operation(summary = "Eliminar Turno por su ID.")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "OK, Turno fué elminado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Meeting.class)) }),
			  @ApiResponse(responseCode = "400", description = "Parámetro Inválido.", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Turno no encontrado.", 
			    content = @Content),
			  @ApiResponse(responseCode = "500", description = "Turno no encontrado.", 
			    content = @Content)})
	@DeleteMapping("/delete/{idMeeting}")
	public String deleteMeeting(@PathVariable Long idMeeting) {
		meetingService.deleteMeetingById(idMeeting);
		return "Se eliminó exitosamente el Meeting con ID = "+ idMeeting;
	}
	
}
