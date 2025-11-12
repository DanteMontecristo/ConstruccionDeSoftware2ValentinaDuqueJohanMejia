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
 * Entidad JPA para orden clínica (clinical_orders).
 * Relaciona con PatientEntity y UserEntity (doctor).
 */
@Entity
@Table(name = "clinical_orders")
public class ClinicalOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Número/identificador del documento que tengas en dominio.
     * Si este campo debe ser único, habilita unique = true.
     */
    @Column(name = "document")
    private Long document;

    /**
     * Relación al paciente.
     * Muchos ClinicalOrder pueden pertenecer a un mismo Patient.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientEntity patientName;

    /**
     * Relación al doctor (usuario).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private UserEntity doctorName;

    @Column(name = "medicine", length = 255)
    private String medicine;

    @Column(name = "doce", length = 255)
    private String doce;

    @Column(name = "date")
    private Date date;

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

    public PatientEntity getPatientName() {
        return patientName;
    }

    public void setPatientName(PatientEntity patientName) {
        this.patientName = patientName;
    }

    public UserEntity getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(UserEntity doctorName) {
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

}