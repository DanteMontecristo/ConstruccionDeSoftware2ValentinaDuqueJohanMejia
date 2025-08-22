package APP.domain.ports;

import APP.domain.model.ClinicalOrder;

public interface ClinicalOrderPort {

    ClinicalOrder findByDocument(Object order);

    void save(ClinicalOrder clinicalOrder);

}
