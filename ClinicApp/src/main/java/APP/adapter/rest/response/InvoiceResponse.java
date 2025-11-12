package APP.adapter.rest.response;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.model.User;

public class InvoiceResponse {

    private Patient name;
    private long document;
    private User doctorName;
    private String insuranceCompany;
    private String policyNumber;
    private String policyValidity;
    private String policyEndingDate;
    private boolean medicine;
    private ClinicalOrder order;
    private String productName;

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Patient getName() {
        return name;
    }
    public void setName(Patient name) {
        this.name = name;
    }
    public long getDocument() {
        return document;
    }
    public void setDocument(long document) {
        this.document = document;
    }
    public User getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(User doctorName) {
        this.doctorName = doctorName;
    }
    public String getInsuranceCompany() {
        return insuranceCompany;
    }
    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    public String getPolicyValidity() {
        return policyValidity;
    }
    public void setPolicyValidity(String policyValidity) {
        this.policyValidity = policyValidity;
    }
    public String getPolicyEndingDate() {
        return policyEndingDate;
    }
    public void setPolicyEndingDate(String policyEndingDate) {
        this.policyEndingDate = policyEndingDate;
    }
    public boolean isMedicine() {
        return medicine;
    }
    public void setisMedicine(boolean medicine) {
        this.medicine = medicine;
    }
    public ClinicalOrder getOrder() {
        return order;
    }
    public void setOrder(ClinicalOrder order) {
        this.order = order;
    }

}
