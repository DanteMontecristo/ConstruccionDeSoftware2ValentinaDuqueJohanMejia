package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.domain.model.ClinicalRecord;
import APP.domain.ports.ClinicalRecordPort;

@Component
public class UpdateClinicalRecord {

    @Autowired
    private ClinicalRecordPort clinicalRecordPort;

    public void update(ClinicalRecord clinicalRecord) throws Exception {
        if (clinicalRecordPort.findByPatient(clinicalRecord) == null) {
            throw new Exception("No existe un historial clinico registrado para este paciente");
        }
        clinicalRecordPort.save(clinicalRecord);
    }
}
