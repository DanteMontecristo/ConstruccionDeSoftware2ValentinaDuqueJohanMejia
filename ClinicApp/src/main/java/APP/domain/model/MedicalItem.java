package APP.domain.model;

public class MedicalItem extends Item {

    private String medicineName;
    private String dose;
    private String treatamentDuration;
    private double cost;

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
