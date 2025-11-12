package APP.adapter.rest.request;


public class InvoiceRequest {

    private String name;
    private String document;
    private String doctorName;
    private String insuranceCompany;
    private String policyNumber;
    private String policyValidity;
    private String policyEndingDate;
    private String isMedicine;
    private String order;
    private String productName;

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument (String document) {
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
    public String getIsMedicine() {
        return isMedicine;
    }
    public void setIsMedicine(String isMedicine) {
        this.isMedicine = isMedicine;
    }
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }

}
