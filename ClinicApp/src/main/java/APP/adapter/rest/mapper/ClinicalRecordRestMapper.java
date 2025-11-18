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
import APP.domain.ports.UserPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ClinicalRecordRestMapper {

    @Autowired
    private ClinicalRecordBuilder clinicalRecordBuilder;

    @Autowired
    private ClinicalRecordValidator clinicalRecordValidator;

    @Autowired
    private UserPort userPort;

    private static final Logger logger = LoggerFactory.getLogger(ClinicalRecordRestMapper.class);

    public ClinicalRecord toDomain(ClinicalRecordRequest req) throws Exception {
        // Support alternative/request variants: user may send `doctorName` and `document` instead
        String doctorDoc = req.getDoctorDocument();
        if ((doctorDoc == null || doctorDoc.isBlank()) && req.getDoctorName() != null) {
            logger.info("Resolviendo doctorDocument desde doctorName='{}'", req.getDoctorName());
            // buscar usuario por nombre
            APP.domain.model.User found = userPort.findByName(req.getDoctorName());
            if (found != null) {
                doctorDoc = String.valueOf(found.getDocument());
            }
        }

        String patientDoc = req.getPatientDocument();
        if ((patientDoc == null || patientDoc.isBlank()) && req.getDocument() != null) {
            patientDoc = req.getDocument();
        }

        String orderId = req.getOrderId();
        if ((orderId == null || orderId.isBlank()) && req.getClinicalOrder() != null) {
            orderId = req.getClinicalOrder();
        }

        ClinicalRecord record = clinicalRecordBuilder.create(
            doctorDoc,
            patientDoc,
            orderId
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
