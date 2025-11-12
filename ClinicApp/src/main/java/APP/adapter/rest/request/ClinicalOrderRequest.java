package APP.adapter.rest.request;

import java.sql.Date;

public class ClinicalOrderRequest {

    private String doctorDocument;
    private String patientDocument;
    private String medicine;
    private String doce;
    private Date date;

    public String getDoctorDocument() {
        return doctorDocument;
    }
    public void setDoctorDocument(String doctorDocument) {
        this.doctorDocument = doctorDocument;
    }
    public String getPatientDocument() {
        return patientDocument;
    }
    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }
    public String getMedicine() {
        return medicine;
    }
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
    public String getDoce() {
        return doce;
    }
    public void setDoce(String doce) {
        this.doce = doce;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
