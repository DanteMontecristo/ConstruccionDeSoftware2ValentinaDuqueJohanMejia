package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.domain.model.Patient;
import APP.domain.ports.PatientPort;

@Component
public class CreatePatient {

    @Autowired
    private PatientPort patientPort;

    public void createPatient(Patient patient) throws Exception {
        if (patientPort.findByDocument(patient) != null) {
			throw new Exception("Ya existe una persona registrada con esa cedula");
		}
        patientPort.save(patient);
    }
    
}
