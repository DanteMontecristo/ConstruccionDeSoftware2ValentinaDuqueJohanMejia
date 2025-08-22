package APP.domain.services;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.model.enums.Role;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.ClinicalRecordPort;
import APP.domain.ports.PatientPort;
import APP.domain.ports.UserPort;

public class CreateClinicalRecord {
    private UserPort userPort;
	private ClinicalOrderPort clinicalOrderPort;
	private ClinicalRecordPort clinicalRecordPort;
	
	public void create(ClinicalRecord clinicalRecord) throws Exception{
		Patient patient = PatientPort.findByDocument(clinicalRecord.getPatient());
		if(patient == null) {
			throw new Exception("la historia debe tener un paciente valida");
		}
		User doctor = userPort.findByDocument(clinicalRecord.getDoctorName());
		if(doctor==null || !doctor.getRole().equals(Role.DOCTOR)) {
			throw new Exception("la historia clinica debe ser registrada por un doctor valido");
		}
		ClinicalOrder clinicalOrder = clinicalOrderPort.findByDocument(clinicalRecord.getClinicalOrder());
		if(clinicalOrder==null) {
			throw new Exception("la historia clinica debe tener una orden valida asociada");
		}
		clinicalRecord.setPatient(patient);
		clinicalRecord.setDoctorName(doctor);
		clinicalRecord.setClinicalOrder(clinicalOrder);
		clinicalRecordPort.save(clinicalRecord);
		
	}
}
