package APP.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @Column(nullable = false, unique = true)
    private long document;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private UserEntity doctorName;

    @Column(name = "insurance_company", length = 100)
    private String insuranceCompany;

    @Column(name = "policy_number", length = 50)
    private String policyNumber;

    @Column(name = "policy_validity", length = 50)
    private String policyValidity;

    @Column(name = "policy_ending_date", length = 50)
    private String policyEndingDate;

    @Column(nullable = false)
    private boolean medicine;

    @ManyToOne
    @JoinColumn(name = "clinical_order_id")
    private ClinicalOrderEntity order;

    @Column(name = "product_name", length = 100)
    private String productName;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public UserEntity getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(UserEntity doctorName) {
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

    public void setMedicine(boolean medicine) {
        this.medicine = medicine;
    }

    public ClinicalOrderEntity getOrder() {
        return order;
    }

    public void setOrder(ClinicalOrderEntity order) {
        this.order = order;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}