package APP.adapter.in.builder;

import APP.domain.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.adapter.in.validators.*;

@Component
public class PatientBuilder {

    @Autowired
    private PatientValidator patientValidator;

    public Patient build(String document, String name, String age, String gender, String address, String phoneNumber, 
    String email) throws Exception{
        Patient patient = new Patient();
        patient.setName(patientValidator.nameValidator(name));
        patient.setDocument(patientValidator.documentValidator(document));
        patient.setAge(patientValidator.ageValidator(age));
        patient.setGender(patientValidator.genderValidator(gender));
        patient.setAddress(patientValidator.addressValidator(address));
        patient.setPhoneNumber(patientValidator.phoneNumberValidator(phoneNumber));;
        patient.setEmail(patientValidator.emailValidator(email));

        return patient;      
    }

    /**
     * Build lightweight Patient used for searches where only document is provided.
     */
    public Patient buildForSearch(String document) throws Exception {
        Patient patient = new Patient();
        patient.setDocument(patientValidator.documentValidator(document));
        return patient;
    }

}
