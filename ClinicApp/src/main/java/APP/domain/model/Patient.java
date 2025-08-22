package APP.domain.model;

import APP.domain.model.enums.PatientGender;

public class Patient {
    private long document;
    private String fullName;
    private int age;
    private PatientGender patientGender;
    private String address;
    private String phoneNumber;
    private String email;

    public long getDocument() {
        return document;
    }
    public void setDocument(long document) {
        this.document = document;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public PatientGender getPatientGender() {
        return patientGender;
    }
    public void setPatientGender(PatientGender patientGender) {
        this.patientGender = patientGender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
