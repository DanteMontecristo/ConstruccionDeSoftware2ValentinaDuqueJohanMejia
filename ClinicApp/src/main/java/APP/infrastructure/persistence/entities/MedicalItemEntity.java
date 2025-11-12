package APP.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;


@Entity
@Table(name = "medical_items")
@Inheritance(strategy = InheritanceType.JOINED)
public class MedicalItemEntity extends ItemEntity {

    @Column(name = "medicine_name", nullable = false, length = 100)
    private String medicineName;

    @Column(nullable = false, length = 50)
    private String dose;

    @Column(name = "treatment_duration", length = 100)
    private String treatamentDuration;

    @Column(nullable = false)
    private double cost;

    // Getters y Setters
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getTreatamentDuration() {
        return treatamentDuration;
    }

    public void setTreatamentDuration(String treatamentDuration) {
        this.treatamentDuration = treatamentDuration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}