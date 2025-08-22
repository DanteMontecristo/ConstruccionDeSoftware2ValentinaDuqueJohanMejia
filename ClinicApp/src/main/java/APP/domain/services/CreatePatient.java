package APP.domain.services;

import APP.domain.model.Patient;
import APP.domain.ports.PatientPort;

public class CreatePatient {
    private PatientPort patientPort;

	public void create(Patient patient) throws Exception {
		if (PatientPort.findByDocument(patient) != null) {
			throw new Exception("ya existe una persona registrada con esa cedula");
		}

		if (patientPort.findByUserName(patient) != null) {
			throw new Exception("ya existe una persona registrada con ese nombre de usuario");
		}
		patientPort.save(patient);
	}
}
