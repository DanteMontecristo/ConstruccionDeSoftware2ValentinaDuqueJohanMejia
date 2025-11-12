package APP.adapter.in.builder;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.adapter.in.validators.ClinicalOrderValidator;
import APP.adapter.in.validators.PatientValidator;
import APP.adapter.in.validators.UserValidator;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.model.User;

@Component
public class ClinicalOrderBuilder {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private PatientValidator patientValidator;

    @Autowired
    private ClinicalOrderValidator clinicalOrderValidator;

    public ClinicalOrder build(String document, String medicine, String doce, String date) throws Exception {
        User doctor = new User();
        Patient patient = new Patient();
        ClinicalOrder clinicalOrder = new ClinicalOrder();
        doctor.setDocument(userValidator.documentValidator(document));
        patient.setDocument(patientValidator.documentValidator(document));
        clinicalOrder.setMedicine(clinicalOrderValidator.medicineValidator(medicine));
        clinicalOrder.setDoce(clinicalOrderValidator.doceValidator(doce));
        clinicalOrder.setDate(new Date(System.currentTimeMillis()));

        return clinicalOrder;
    }

    public ClinicalOrder build(String doctorDocument, String patientDocument, String medicine, String doce, Date date) {
        throw new UnsupportedOperationException();
    }

}
