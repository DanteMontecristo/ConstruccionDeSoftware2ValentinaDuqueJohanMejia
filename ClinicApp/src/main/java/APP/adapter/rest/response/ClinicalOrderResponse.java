package APP.adapter.rest.response;

import java.sql.Date;

public class ClinicalOrderResponse {

    private long id;
    private long patientDocument;
    private long doctorDocument;
    private String medicine;
    private String doce;
    private Date date;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getPatientDocument() {
        return patientDocument;
    }
    public void setPatientDocument(long patientDocument) {
        this.patientDocument = patientDocument;
    }
    public long getDoctorDocument() {
        return doctorDocument;
    }
    public void setDoctorDocument(long doctorDocument) {
        this.doctorDocument = doctorDocument;
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
