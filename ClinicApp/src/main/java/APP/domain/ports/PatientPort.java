package APP.domain.ports;

import APP.domain.model.Patient;

public interface PatientPort {
    public static Patient findByDocument(Object patient) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDocument'");
    }
    public Patient findByUserName(Patient patient) throws Exception;
    public void save(Patient patient) throws Exception;
    public Patient findById(String patientName);
}
