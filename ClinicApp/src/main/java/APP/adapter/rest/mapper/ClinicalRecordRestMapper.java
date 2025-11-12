package APP.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.adapter.in.builder.ClinicalRecordBuilder;
import APP.adapter.in.validators.ClinicalRecordValidator;
import APP.adapter.rest.request.ClinicalRecordRequest;
import APP.adapter.rest.response.ClinicalRecordResponse;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.model.User;

@Component
public class ClinicalRecordRestMapper {

    @Autowired
    private ClinicalRecordBuilder clinicalRecordBuilder;

    @Autowired
    private ClinicalRecordValidator clinicalRecordValidator;

    public ClinicalRecord toDomain(ClinicalRecordRequest req) throws Exception {
        ClinicalRecord record = clinicalRecordBuilder.create(
            req.getDoctorDocument(),
            req.getPatientDocument(),
            req.getOrderId()
        );
            
        // Optional details validated if present
        if (req.getMotive() != null) record.setMotive(clinicalRecordValidator.motiveValidator(req.getMotive()));
        if (req.getDiagnosis() != null) record.setDiagnosis(clinicalRecordValidator.diagnosisValidator(req.getDiagnosis()));
        if (req.getMedicine() != null) record.setMedicine(clinicalRecordValidator.medicineValidator(req.getMedicine()));
        if (req.getMedicalProcedure() != null) record.setMedicalProcedure(clinicalRecordValidator.procedureValidator(req.getMedicalProcedure()));
        if (req.getProcedureDetail() != null) record.setProceddureDetail(clinicalRecordValidator.procedureDetailsValidator(req.getProcedureDetail()));
        if (req.getVaccinationRecord() != null) record.setVaccinationRecord(clinicalRecordValidator.vaccinationValidator(req.getVaccinationRecord()));
        if (req.getAllergies() != null) record.setAllergies(clinicalRecordValidator.allergiesValidator(req.getAllergies()));
        if (req.getSymptoms() != null) record.setSymptoms(clinicalRecordValidator.symptomsValidator(req.getSymptoms()));
        if (req.getDoce() != null) record.setDoce(clinicalRecordValidator.doceValidator(req.getDoce()));

        return record;
    }

    public ClinicalRecordResponse toResponse(ClinicalRecord record) {
        ClinicalRecordResponse res = new ClinicalRecordResponse();
        res.setId(record.getId());
        Patient patient = record.getName();
        res.setPatientDocument(patient != null ? patient.getDocument() : 0);
        User doc = record.getDoctorName();
        res.setDoctorDocument(doc != null ? doc.getDocument() : 0);
        ClinicalOrder order = record.getClinicalOrder();
        res.setOrderId(order != null ? order.getId() : 0);
        res.setDate(record.getDate());
        res.setMotive(record.getMotive());
        res.setDiagnosis(record.getDiagnosis());
        res.setMedicine(record.getMedicine());
        res.setMedicalProcedure(record.getMedicalProcedure());
        res.setProcedureDetail(record.getProceddureDetail());
        res.setVaccinationRecord(record.getVaccinationRecord());
        res.setAllergies(record.getAllergies());
        res.setSymptoms(record.getSymptoms());
        res.setStatus(record.isStatus());
        return res;
    }
}
