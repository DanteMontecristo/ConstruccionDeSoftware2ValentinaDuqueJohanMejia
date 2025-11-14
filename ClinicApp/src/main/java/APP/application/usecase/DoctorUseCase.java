package APP.application.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.services.CreateClinicalRecord;
import APP.domain.services.SearchClinicalRecordByPatient;
import APP.domain.services.UpdateClinicalRecord;

@Component
public class DoctorUseCase {

    @Autowired
    private SearchClinicalRecordByPatient searchClinicalRecordByPatient;
    
    @Autowired
    private CreateClinicalRecord createClinicalRecord;
    
    @Autowired
    private UpdateClinicalRecord updateClinicalRecord;
    
    @Autowired
    private APP.domain.services.CreateClinicalOrder createClinicalOrder;

    public List<ClinicalRecord> searchClinicalRecord(Patient patient) throws Exception{
		return searchClinicalRecordByPatient.search(patient);
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
