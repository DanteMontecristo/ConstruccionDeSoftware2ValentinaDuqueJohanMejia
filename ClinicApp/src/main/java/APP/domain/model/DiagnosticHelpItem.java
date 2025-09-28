package APP.domain.model;

public class DiagnosticHelpItem extends Item {

    private String detail;
    private String amount;
    private double cost;
    private boolean specialist;
    
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
