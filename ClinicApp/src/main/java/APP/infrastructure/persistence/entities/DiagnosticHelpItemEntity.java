package APP.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;


@Entity
@Table(name = "diagnostic_help_items")
@Inheritance(strategy = InheritanceType.JOINED)
public class DiagnosticHelpItemEntity extends ItemEntity {

    @Column(nullable = false, length = 255)
    private String detail;

    @Column(nullable = false, length = 50)
    private String amount;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private boolean specialist;

    // Getters y Setters
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isSpecialist() {
        return specialist;
    }

    public void setSpecialist(boolean specialist) {
        this.specialist = specialist;
    }
}