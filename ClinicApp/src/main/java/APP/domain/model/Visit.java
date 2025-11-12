package APP.domain.model;

public class Visit {

    private long document;
    private String visitName;
    private User name;
    
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
    public User getName() {
        return name;
    }
    public void setName(User name) {
        this.name = name;
    }

}
