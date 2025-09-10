package APP.domain.services;

import APP.domain.model.Patient;
import APP.domain.repository.PatientPort;

public class CreatePatient {

    private PatientPort patientPort;

    public void createPatient(Patient patient) throws Exception {
        if (patientPort.findByDocument(patient) != null) {
			throw new Exception("Ya existe una persona registrada con esa cedula");
		}
        patientPort.save(patient);
    }
    
}
