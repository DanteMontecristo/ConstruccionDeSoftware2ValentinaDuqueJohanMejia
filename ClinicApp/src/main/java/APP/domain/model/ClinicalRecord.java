package APP.domain.model;

import java.security.cert.CertPathValidatorException.Reason;
import java.sql.Date;
import javax.management.relation.Role;

import APP.domain.model.enums.ReasonsForConsultation;

//Expediente medico
public class ClinicalRecord {
    private Date date;
	private long doctorDocument;
    private ReasonsForConsultation reasonForConsultation;
    private String symptomatology;
    private String diagnostic;

    public String getPatient() {
        throw new UnsupportedOperationException();
    }
    public Object getClinicalOrder() {
        throw new UnsupportedOperationException();
    }
    public User getDoctorName() {
        throw new UnsupportedOperationException();
    }
    public void setPatient(Patient patient) {
        throw new UnsupportedOperationException();
    }
    public void setDoctorName(User doctor) {
        throw new UnsupportedOperationException();
    }
    public void setClinicalOrder(ClinicalOrder clinicalOrder) {
        throw new UnsupportedOperationException();
    }
}
