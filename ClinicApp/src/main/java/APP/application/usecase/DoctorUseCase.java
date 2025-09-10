package APP.application.usecase;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.services.CreateClinicalRecord;
import APP.domain.services.SearchPatientByDocument;
import APP.domain.services.UpdateClinicalRecord;

public class DoctorUseCase {

    private SearchPatientByDocument searchPatientByDocument;
    private CreateClinicalRecord createClinicalRecord;
    private UpdateClinicalRecord updateClinicalRecord;
    private APP.domain.services.CreateClinicalOrder createClinicalOrder;

    public void searchPatient(Patient patient) throws Exception{
        searchPatientByDocument.search(patient);
    }

    public void createClinicalRecord(ClinicalRecord clinicalRecord) throws Exception{
        createClinicalRecord.create(clinicalRecord);
    }

    public void updateClinicalRecord(ClinicalRecord clinicalRecord) throws Exception{
        updateClinicalRecord.update(clinicalRecord);
    }

    public void createClinicalOrder(ClinicalOrder clinicalOrder) throws Exception{
        createClinicalOrder.create(clinicalOrder);
    }
}
//- Crear orden procedimiento
//- Crear ayuda diagnostica