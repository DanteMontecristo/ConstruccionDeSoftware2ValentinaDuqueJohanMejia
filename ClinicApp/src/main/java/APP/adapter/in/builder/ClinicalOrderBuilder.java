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
        // Legacy signature kept for compatibility if used elsewhere.
        User doctor = new User();
        Patient patient = new Patient();
        ClinicalOrder clinicalOrder = new ClinicalOrder();
        doctor.setDocument(userValidator.documentValidator(document));
        patient.setDocument(patientValidator.documentValidator(document));
        clinicalOrder.setDoctorName(doctor);
        clinicalOrder.setName(patient);
        clinicalOrder.setMedicine(clinicalOrderValidator.medicineValidator(medicine));
        clinicalOrder.setDoce(clinicalOrderValidator.doceValidator(doce));
        clinicalOrder.setDate(new Date(System.currentTimeMillis()));

        return clinicalOrder;
    }

    public ClinicalOrder build(String doctorDocument, String patientDocument, String medicine, String doce, Date date) throws Exception {
        User doctor = new User();
        Patient patient = new Patient();
        ClinicalOrder clinicalOrder = new ClinicalOrder();

        // validate and set doctor document
        doctor.setDocument(userValidator.documentValidator(doctorDocument));

        // validate and set patient document
        Long patientDoc = patientValidator.documentValidator(patientDocument);
        patient.setDocument(patientDoc);

        clinicalOrder.setDoctorName(doctor);
        clinicalOrder.setName(patient);

        clinicalOrder.setMedicine(clinicalOrderValidator.medicineValidator(medicine));
        clinicalOrder.setDoce(clinicalOrderValidator.doceValidator(doce));

        if (date != null) {
            clinicalOrder.setDate(date);
        } else {
            clinicalOrder.setDate(new Date(System.currentTimeMillis()));
        }

        // set document field on clinical order to patient's document
        clinicalOrder.setDocument(patient.getDocument());

        return clinicalOrder;
    }

}
