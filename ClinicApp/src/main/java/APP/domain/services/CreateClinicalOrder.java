package APP.domain.services;

import APP.domain.repository.UserPort;

import java.util.List;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.repository.ClinicalOrderPort;
import APP.domain.repository.PatientPort;
import APP.domain.model.enums.Role;

//@Service
public class CreateClinicalOrder {
    private UserPort userPort;
    private PatientPort patientPort;
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

        clinicalOrder.setPatientName(patient);
        clinicalOrder.setDoctorName(doctor);
        clinicalOrderPort.save(clinicalOrder);
    }

    public List<ClinicalOrder> search(Patient patient) {
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
}
