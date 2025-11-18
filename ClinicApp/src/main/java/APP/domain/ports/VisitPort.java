package APP.domain.ports;

import APP.domain.model.Visit;

public interface VisitPort {
    
    public void save(Visit visit) throws Exception;
}
