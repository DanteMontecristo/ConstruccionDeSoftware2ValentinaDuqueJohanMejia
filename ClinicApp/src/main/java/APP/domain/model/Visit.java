package APP.domain.model;

public class Visit {

    private long document;
    private String visitName;
    private User patientName;
    
    public long getDocument() {
        return document;
    }
    public void setDocument(long document) {
        this.document = document;
    }
    public String getVisitName() {
        return visitName;
    }
    public void setVisitName(String visitName) {
        this.visitName = visitName;
    }
    public User getPatientName() {
        return patientName;
    }
    public void setPatientName(User patientName) {
        this.patientName = patientName;
    }

}
