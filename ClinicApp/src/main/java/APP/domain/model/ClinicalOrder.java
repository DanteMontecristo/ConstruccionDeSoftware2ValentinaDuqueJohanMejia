package APP.domain.model;

import java.sql.Date;

public class ClinicalOrder {
    private long document;
    private Patient patientName;
    private User doctorName;
    private String medicine;
    private String doce;
    private Date date;
    private long id;


    public long getDocument() {
        return document;
    }
    public void setDocument(long document) {
        this.document = document;
    }
    public Patient getPatientName() {
        return patientName;
    }
    public void setPatientName(Patient patientName) {
        this.patientName = patientName;
    }
    public User getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(User doctorName) {
        this.doctorName = doctorName;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
