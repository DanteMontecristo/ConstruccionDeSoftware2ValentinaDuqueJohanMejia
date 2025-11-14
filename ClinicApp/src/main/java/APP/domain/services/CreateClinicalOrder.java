package APP.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.model.enums.Role;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.PatientPort;
import APP.domain.ports.UserPort;

@Component
public class CreateClinicalOrder {
    
    @Autowired
    private UserPort userPort;
    
    @Autowired
    private PatientPort patientPort;
    
    @Autowired
    private ClinicalOrderPort clinicalOrderPort;

    public void create(ClinicalOrder clinicalOrder) throws Exception {
        User doctor = userPort.findByDocument(clinicalOrder.getDoctorName());
        if(doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("Las ordenes solo la puede crear un doctor");
        }
        Patient posiblePatient = new Patient();
        posiblePatient.setDocument(clinicalOrder.getDocument());
        Patient patient = patientPort.findByDocument(posiblePatient);
        if(patient == null) {
            throw new Exception("Las ordenes se deben de aplicar a pacientes registrados");
        }

        clinicalOrder.setName(patient);
        clinicalOrder.setDoctorName(doctor);
        clinicalOrderPort.save(clinicalOrder);
    }

    public List<ClinicalOrder> search(Patient patient) {
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
}
