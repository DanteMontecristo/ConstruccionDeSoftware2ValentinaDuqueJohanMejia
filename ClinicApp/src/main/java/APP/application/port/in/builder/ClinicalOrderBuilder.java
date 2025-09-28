package APP.application.port.in.builder;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.application.port.in.validators.ClinicalOrderValidator;
import APP.application.port.in.validators.PatientValidator;
import APP.application.port.in.validators.UserValidator;
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

    public ClinicalOrder build(String id, String document, String patientName, String name, String medicine, String doce) throws Exception {
        User doctor = new User();
        Patient patient = new Patient();
        ClinicalOrder clinicalOrder = new ClinicalOrder();
        doctor.setDocument(userValidator.documentValidator(document));
        patient.setDocument(patientValidator.documentValidator(document));
        clinicalOrder.setDoctorName(doctor); // DoctorName- Doctor
        clinicalOrder.setPatientName(patient); // PatientName- Patient
        clinicalOrder.setMedicine(clinicalOrderValidator.medicineValidator(medicine));
        clinicalOrder.setDoce(clinicalOrderValidator.doceValidator(doce));
        clinicalOrder.setDate(new Date(System.currentTimeMillis()));

        return clinicalOrder;
    }
}
