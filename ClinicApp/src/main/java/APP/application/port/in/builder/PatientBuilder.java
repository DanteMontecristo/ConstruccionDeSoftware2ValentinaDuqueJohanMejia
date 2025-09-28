package APP.application.port.in.builder;

import APP.domain.model.Patient;
import APP.application.port.in.validators.*;

public class PatientBuilder {

    private PatientValidator patientValidator;

    public Patient build(String document, String patientName, String age, String gender, String address, String phoneNumber, 
    String email) throws Exception{
        Patient patient = new Patient();
        patient.setPatientName(patientValidator.patientNameValidator(patientName));
        patient.setDocument(patientValidator.documentValidator(document));
        patient.setAge(patientValidator.ageValidator(age));
        patient.setGender(patientValidator.genderValidator(gender));
        patient.setAddress(patientValidator.addressValidator(address));
        patient.setPhoneNumber(patientValidator.phoneNumberValidator(phoneNumber));;
        patient.setEmail(patientValidator.emailValidator(email));

        return patient;      
    }

}
