package APP.adapter.rest.request;

public class VisitRequest {
    
    private String document;      // documento del paciente
    private String visitName;     // nombre/tipo de la visita
    private String userName;      // username/nombre del enfermero (opcional)
    
    public String getDocument() {
        return document;
    }
    
    public void setDocument(String document) {
        this.document = document;
    }
    
    public String getVisitName() {
        return visitName;
    }
    
    public void setVisitName(String visitName) {
        this.visitName = visitName;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
