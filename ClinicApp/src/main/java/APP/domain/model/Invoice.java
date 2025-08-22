package APP.domain.model;

import java.sql.Date;

public class Invoice {
    private String patientName;
    private int age;
    private long document;
	private String doctorName;
	private String insuranceCompany;
    private int policyNumber;
	private int policyValidityDays;
    private Date date;

    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public long getDocument() {
        return document;
    }
    public void setDocument(long document) {
        this.document = document;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public String getInsuranceCompany() {
        return insuranceCompany;
    }
    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
    public int getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }
    public int getPolicyValidityDays() {
        return policyValidityDays;
    }
    public void setPolicyValidityDays(int policyValidityDays) {
        this.policyValidityDays = policyValidityDays;
    }
    public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
    }
    public boolean isMedicine() {

        throw new UnsupportedOperationException();
    }
    public Object getOrder() {

        throw new UnsupportedOperationException();
    }
    public void setOrder(ClinicalOrder clinicalOrder) {

        throw new UnsupportedOperationException();
    }

}
