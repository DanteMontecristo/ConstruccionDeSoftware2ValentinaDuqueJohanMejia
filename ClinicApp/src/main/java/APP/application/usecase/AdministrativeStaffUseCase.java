package APP.application.usecase;

import APP.domain.services.CreatePatient;
import APP.domain.model.Patient;

public class AdministrativeStaffUseCase {

    private CreatePatient createPatient;

    public void createPatient(Patient patient) throws Exception{
		createPatient.createPatient(patient);
	}
}
