package APP.domain.ports;

import APP.domain.model.ClinicalRecord;

public interface ClinicalRecordPort {

    void save(ClinicalRecord clinicalRecord);

}
