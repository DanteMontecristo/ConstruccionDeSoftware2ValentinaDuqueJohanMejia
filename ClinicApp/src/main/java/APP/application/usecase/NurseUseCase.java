package APP.application.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.services.RegisterVisit;
import APP.domain.services.SearchClinicalOrderByPatient;
import APP.domain.services.SearchPatientByDocument;

@Component
public class NurseUseCase {

    @Autowired
    private SearchClinicalOrderByPatient searchClinicalOrderByPatient;
    
    @Autowired
    private SearchPatientByDocument searchPatientByDocument;
    
    @Autowired
    private RegisterVisit segisterVisit;

    public List<ClinicalOrder> searchClinicalOrder(Patient patient) throws Exception{
		return searchClinicalOrderByPatient.search(patient);
	}

    public void searchPatient(Patient patient) throws Exception{
        searchPatientByDocument.search(patient);
    }

    public void registerVisit(Patient patient) throws Exception{
        segisterVisit.registerVisit(patient);
    }
}
