/**
 * 
 */
package ar.edu.unju.fi.clinica.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import ar.edu.unju.fi.clinica.DTO.DoctorDTO;
import ar.edu.unju.fi.clinica.DTO.MedicalPlanDTO;
import ar.edu.unju.fi.clinica.DTO.MeetingDTO;
import ar.edu.unju.fi.clinica.DTO.OfficeDTO;
import ar.edu.unju.fi.clinica.DTO.PatientDTO;
import ar.edu.unju.fi.clinica.DTO.RoleDTO;
import ar.edu.unju.fi.clinica.DTO.UserDTO;
import ar.edu.unju.fi.clinica.Entity.Doctor;
import ar.edu.unju.fi.clinica.Entity.MedicalPlan;
import ar.edu.unju.fi.clinica.Entity.Meeting;
import ar.edu.unju.fi.clinica.Entity.Office;
import ar.edu.unju.fi.clinica.Entity.Patient;
import ar.edu.unju.fi.clinica.Entity.Role;
import ar.edu.unju.fi.clinica.Entity.User;


/**
 * @author Diaz, Sebastián Darío
 * Clase contenedore de métodos de mapeo. Desde un DTO a una entidad y viceversa.
 */
public class Mapper {
	private static final ModelMapper mapper = new ModelMapper();
	
	/**
	 * Método que mapea un Objeto Role a RoleDTO.
	 * @param rol - Entidad Role.
	 * @return Un Objeto de tipo RoleDTO.
	 */
	public static RoleDTO mapToRolDTO(Role rol) {
		return mapper.map(rol, RoleDTO.class);
	}
	
	/**
	 * Método que mapea un Objeto RoleDTO a Role.
	 * @param rolDTO - Objeto de tipo RoleDTO.
	 * @return Entidad Role.
	 */
	public static Role mapToRol(RoleDTO rolDTO) {
		return mapper.map(rolDTO, Role.class);
	}
	
	/**
	 * Método que mapea una Lista de Entidades Role a una Lista de tipo RoleDTO.
	 * @param listRoles - List de Entidades Role.
	 * @return Un List que contiene Objetos de tipo RoleDTO.
	 */
	public static List<RoleDTO> mapToListRolDTO(List<Role> listRoles){
		List<RoleDTO> listRolesDTO = new ArrayList<>();
		RoleDTO rolDTO = new RoleDTO();
		for(Role r:listRoles) {
			rolDTO = mapper.map(r,RoleDTO.class);
			listRolesDTO.add(rolDTO);
		}
		return listRolesDTO;
	}
	
	/**
	 * Método que mapea una Lista de Objetos de tipo RoleDTO a una Lista de Entidades Role.
	 * @param listRolesDTO q- List que contiene Objetos de tipo RoleDTO.
	 * @return Un List de Entidades Role.
	 */
	public static List<Role> mapToListRol(List<RoleDTO> listRolesDTO){
		List<Role> listRoles = new ArrayList<>();
		Role rol = new Role();
		for(RoleDTO r:listRolesDTO) {
			rol = mapper.map(r, Role.class);
			listRoles.add(rol);
		}
		return listRoles;
	}
	
	/**
	 * Método que mapea una Entidad User a UserDTO.
	 * @param user - Entidad User.
	 * @return Un Objeto de tipo UserDTO.
	 */
	public static UserDTO mapToUserDTO(User user) {
		return mapper.map(user, UserDTO.class);
	}
	
	/**
	 * Método que mapea un Objeto UserDTO a User.
	 * @param userDTO - Objeto de tipo UserDTO.
	 * @return Entidad User.
	 */
	public static User mapToUser(UserDTO userDTO) {
		return mapper.map(userDTO, User.class);
	}
	
	/**
	 * Método que mapea una Lista de Entidades User a una Lista de Objetos de tipo UserDTO.
	 * @param listUsers - List que contiene entidades User.
	 * @return Un List de objetos de tipo UserDTO.
	 */
	public static List<UserDTO> mapToListUserDTO(List<User> listUsers){
		List<UserDTO> listUsersDTO = new ArrayList<>();
		UserDTO userDTO = new UserDTO();
		for(User u:listUsers) {
			userDTO = mapper.map(u, UserDTO.class);
			listUsersDTO.add(userDTO);
		}
		return listUsersDTO;
	}
	
	/**
	 * Método que mapea una Lista de Objetos de tipo UserDTO a una Lista de Entidades User.
	 * @param listUsersDTO - List que contiene Objetos de tipo UserDTO.
	 * @return Un List de entidades User.
	 */
	public static List<User> mapToListUser(List<UserDTO> listUsersDTO){
		List<User> listUsers = new ArrayList<>();
		User user = new User();
		for(UserDTO u:listUsersDTO) {
			user = mapper.map(u, User.class);
			listUsers.add(user);
		}
		return listUsers;
	}

	/**
	 * Método que mapea una Entidad MedicalPlan a un Objeto de tipo MedicalPlanDTO.
	 * @param medicalPlan - List que contiente Entidades MedicalPlan.
	 * @return Un List que contiene Objetos de tipo MedicalPlanDTO.
	 */
	public static MedicalPlanDTO mapToMedicalPlanDTO(MedicalPlan medicalPlan) {
		return mapper.map(medicalPlan, MedicalPlanDTO.class);
	}
	
	/**
	 * Método que mapea un Objeto MedicalPlanDTO a una Entidad MedicalPlan.
	 * @param medicalPlanDTO - Objeto de tipo MedicalPlanDTO.
	 * @return Entidad MedicalPlan.
	 */
	public static MedicalPlan mapToMedicalPlan(MedicalPlanDTO medicalPlanDTO) {
		return mapper.map(medicalPlanDTO, MedicalPlan.class);
	}
	
	/**
	 * Método que mapea una Lista de Entidades MedicalPlan a una Lista de Objetos MedicalPlanDTO.
	 * @param listMedicalPlans - List que contiene Entidades MedicalPlan.
	 * @return Un List de Objetos de tipo MediocalPlanDTO.
	 */
	public static List<MedicalPlanDTO> mapToListMedicalPlanDTO(List<MedicalPlan> listMedicalPlans){
		List<MedicalPlanDTO> listMedicalPlansDTO = new ArrayList<>();
		MedicalPlanDTO medicalPlanDTO = new MedicalPlanDTO();
		for(MedicalPlan m: listMedicalPlans) {
			medicalPlanDTO = mapper.map(m, MedicalPlanDTO.class);
			listMedicalPlansDTO.add(medicalPlanDTO);
		}
		return listMedicalPlansDTO;
	}
	
	/**
	 * Método que mapea una Lista de Objetos MedicalPlanDTO a una Lista de Entidades MedicalPlan.
	 * @param listMedicalPlansDTO - List que contiene Objetos de tipo MedicalPlanDTO.
	 * @return Un List que contiene Entidades MedicalPlan.
	 */
	public static List<MedicalPlan> mapToListMedicalPlan(List<MedicalPlanDTO> listMedicalPlansDTO){
		List<MedicalPlan> listMedicalPlans = new ArrayList<>();
		MedicalPlan medicalPlan = new MedicalPlan();
		for(MedicalPlanDTO m:listMedicalPlansDTO) {
			medicalPlan = mapper.map(m, MedicalPlan.class);
			listMedicalPlans.add(medicalPlan);
		}
		return listMedicalPlans;
	}
	
	/**
	 * Método que mapea Entidad Doctor a un Objeto DoctorDTO.
	 * @param doctorAux - Entidad Doctor.
	 * @return Objeto DoctorDTO.
	 */
	public static DoctorDTO mapToDoctorDTO(Doctor doctorAux) {
		return mapper.map(doctorAux, DoctorDTO.class);
	}
	
	/**
	 * Método que mapea un Objeto DoctorDTO a una Entidad Doctor.
	 * @param doctorDTO - Objeto de tipo DoctorDTO.
	 * @return Entidad Doctor.
	 */
	public static Doctor mapToDoctor(DoctorDTO doctorDTO) {
		return mapper.map(doctorDTO, Doctor.class);
	}
	
	/**
	 * Método que mapea una Lista de Entidades Doctor a una Lista de Objetos DoctorDTO.
	 * @param listDoctor - List que contiene Entidades Doctor.
	 * @return Un List que contiene Objetos de tipo DoctorDTO.
	 */
	public static List<DoctorDTO> mapToListDoctorDTO(List<Doctor> listDoctor){
		List<DoctorDTO> listDoctorDTO = new ArrayList<>();
		DoctorDTO doctorDTO = new DoctorDTO();
		for (Doctor d : listDoctor) {
			doctorDTO = mapper.map(d, DoctorDTO.class);
			listDoctorDTO.add(doctorDTO);
		}
		return listDoctorDTO;
	}
	
	/**
	 * Método que mapea una Lista de Objetos DoctorDTO a una Lista de Entidades Doctor.
	 * @param listDoctorDTO - List que contiene Objetos DoctorDTO.
	 * @return Un List que contiene Entidades Doctor.
	 */
	public static List<Doctor> mapToListDoctor(List<DoctorDTO> listDoctorDTO){
		List<Doctor> listDoctor = new ArrayList<>();
		Doctor doctor = new Doctor();
		for(DoctorDTO d: listDoctorDTO) {
			doctor = mapper.map(d, Doctor.class);
			listDoctor.add(doctor);
		}
		return listDoctor;
	}
	
	/**
	 * Método que mapea una Entidad Patient a un Objeto PatientDTO.
	 * @param patient - Entidad Patient.
	 * @return Objeto PatientDTO.
	 */
	public static PatientDTO mapToPatientDTO(Patient patient) {
		return mapper.map(patient, PatientDTO.class);
	}
	
	/**
	 * Método que mapea un Objeto PatientDTO a una Entidad Patient.
	 * @param patientDTO - Objeto PatientDTO.
	 * @return Entidad Patient.
	 */
	public static Patient mapToPatient(PatientDTO patientDTO) {
		return mapper.map(patientDTO, Patient.class);
	}

	/**
	 * Método que mapea una Lista de Entidades Patient a una Lista de Objetos PatientDTO.
	 * @param listPatient - List que contiene Entidades Patient.
	 * @return Un List que contiene Objetos PatientDTO.
	 */
	public static List<PatientDTO> mapToListPatientDTO(List<Patient> listPatient){
		List<PatientDTO> listPatientDTO = new ArrayList<>();
		PatientDTO patientDTO = new PatientDTO();
		for(Patient p: listPatient) {
			patientDTO = mapper.map(p, PatientDTO.class);
			listPatientDTO.add(patientDTO);
		}
		return listPatientDTO;
	}
	
	/**
	 * Método que mapea una Lista de Objetos PatientDTO a una Lista de Entidades Patient.
	 * @param listPatientDTO - List que contiene Objetos PatientDTO.
	 * @return Un List que contiene Entidades Patient.
	 */
	public static List<Patient> mapToListPatient(List<PatientDTO> listPatientDTO){
		List<Patient> listPatient = new ArrayList<>();
		Patient patient = new Patient();
		for(PatientDTO p: listPatientDTO) {
			patient = mapper.map(p, Patient.class);
			listPatient.add(patient);
		}
		return listPatient;
	}
	
	/**
	 * Método que mapea un Objeto OfficeDTO a una Entidad Office.
	 * @param officeDTO - Objeto OfficeDTO.
	 * @return Entidad Office.
	 */
	public static Office mapToOffice(OfficeDTO officeDTO){
		return mapper.map(officeDTO, Office.class);
	}
	
	/**
	 * Método que mapea una Entidad Office a un Objeto OfficeDTO.
	 * @param office - Entidad Office.
	 * @return Objeto OfficeDTO.
	 */
	public static OfficeDTO mapToOfficeDTO(Office office) {
		return mapper.map(office, OfficeDTO.class);
	}
	
	/**
	 * Método que mapea una Lista de Objetos OfficeDTO a una Lista de Entidades Office.
	 * @param listOfficeDTO - List que contiene Objetos OfficeDTO.
	 * @return List que contiene Entidades Office.
	 */
	public static List<Office> mapToListOffice(List<OfficeDTO> listOfficeDTO){
		List<Office> listOffice = new ArrayList<>();
		Office office = new Office();
		for(OfficeDTO o:listOfficeDTO) {
			office = mapper.map(o, Office.class);
			listOffice.add(office);
		}
		return listOffice;
	}
	
	/**
	 * Método que mapea una Lista de Entidades Office a una Lista de Objetos OfficeDTO.
	 * @param listOffice - List que contiene Entidades Office.
	 * @return List que contiene Objetos OfficeDTO.
	 */
	public static List<OfficeDTO> mapTotListOfficeDTO(List<Office> listOffice){
		List<OfficeDTO> listOfficeDTO = new ArrayList<>();
		OfficeDTO officeDTO = new OfficeDTO();
		for(Office o: listOffice) {
			officeDTO = mapper.map(o, OfficeDTO.class);
			listOfficeDTO.add(officeDTO);
		}
		return listOfficeDTO;
	}
	
	/**
	 * Método que mapea un Objeto MeetingDTO a una Entidad Meeting.
	 * @param meetingDTO - Objeto MeetingDTO.
	 * @return Entidad Meeting.
	 */
	public static Meeting mapToMeeting(MeetingDTO meetingDTO) {
		return mapper.map(meetingDTO, Meeting.class);
	}
	
	/**
	 * Método que mapea una Entidad Meeting a un Objeto MeetingDTO.
	 * @param meeting - Entidad Meeting.
	 * @return Objeto MeetingDTO.
	 */
	public static MeetingDTO mapToMeetingDTO(Meeting meeting) {
		return mapper.map(meeting, MeetingDTO.class);
	}
	
}
