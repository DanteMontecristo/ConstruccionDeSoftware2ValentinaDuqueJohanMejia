package APP.domain.services;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.model.enums.Role;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.PatientPort;
import APP.domain.ports.UserPort;

public class CreateClinicalOrder {
    private UserPort userPort;
	private ClinicalOrderPort clinicalOrderPort;

	public void create(ClinicalOrder clinicalOrder) throws Exception {
		User doctor = userPort.findByDocument(clinicalOrder.getDoctorName());
		if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
			throw new Exception("Las ordenes solo las pueden crear doctores");
		}
		Patient patient = PatientPort.findByDocument(clinicalOrder.getPatientName());
		if (patient == null) {
			throw new Exception("las ordenes se deben aplicar a pacientes registrados");
		}
		
		clinicalOrder.setPatient(patient);
		clinicalOrder.setDoctorName(doctor);
		
		clinicalOrderPort.save(clinicalOrder);
	}
}
