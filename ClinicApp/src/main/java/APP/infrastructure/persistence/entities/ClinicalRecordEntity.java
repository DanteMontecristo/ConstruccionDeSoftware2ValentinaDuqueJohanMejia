package APP.infrastructure.persistence.entities;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad JPA para clinical_records
 */
@Entity
@Table(name = "clinical_records")
public class ClinicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document")
    private Long document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private UserEntity doctorName;

    @Column(name = "date")
    private Date date;

    @Column(name = "motive", length = 500)
    private String motive;

    @Column(name = "diagnosis", length = 1000)
    private String Diagnosis;

    @Column(name = "medicine", length = 1000)
    private String medicine;

    @Column(name = "medical_procedure", length = 1000)
    private String medicalProcedure;

    @Column(name = "doce", length = 500)
    private String doce;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_order_id")
    private ClinicalOrderEntity clinicalOrder;

    @Column(name = "vaccination_record", length = 500)
    private String vaccinationRecord;

    @Column(name = "allergies", length = 500)
    private String allergies;

    @Column(name = "proceddure_detail", length = 1000)
    private String proceddureDetail;

    @Column(name = "symptoms", length = 1000)
    private String symptoms;

    @Column(name = "status")
    private Boolean status;

    // Getters / Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public UserEntity getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(UserEntity doctorName) {
        this.doctorName = doctorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        Diagnosis = diagnosis;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getMedicalProcedure() {
        return medicalProcedure;
    }

    public void setMedicalProcedure(String medicalProcedure) {
        this.medicalProcedure = medicalProcedure;
    }

    public String getDoce() {
        return doce;
    }

    public void setDoce(String doce) {
        this.doce = doce;
    }

    public ClinicalOrderEntity getClinicalOrder() {
        return clinicalOrder;
    }

    public void setClinicalOrder(ClinicalOrderEntity clinicalOrder) {
        this.clinicalOrder = clinicalOrder;
    }

    public String getVaccinationRecord() {
        return vaccinationRecord;
    }

    public void setVaccinationRecord(String vaccinationRecord) {
        this.vaccinationRecord = vaccinationRecord;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getProceddureDetail() {
        return proceddureDetail;
    }

    public void setProceddureDetail(String proceddureDetail) {
        this.proceddureDetail = proceddureDetail;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}