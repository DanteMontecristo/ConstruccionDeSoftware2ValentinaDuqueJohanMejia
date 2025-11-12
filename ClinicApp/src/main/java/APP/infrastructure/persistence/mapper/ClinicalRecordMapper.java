package APP.infrastructure.persistence.mapper;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.infrastructure.persistence.entities.ClinicalOrderEntity;
import APP.infrastructure.persistence.entities.ClinicalRecordEntity;
import APP.infrastructure.persistence.entities.PatientEntity;
import APP.infrastructure.persistence.entities.UserEntity;

import java.sql.Date;

/**
 * Mapper entre ClinicalRecordEntity <-> APP.domain.model.ClinicalRecord
 *
 * Usa:
 * - PatientEntityMapper
 * - UserEntityMapper
 * - ClinicalOrderEntityMapper
 *
 * Null-safe y respetando que en el dominio id/document son primitivos (0/0L = no seteado).
 */
public final class ClinicalRecordMapper {

    private ClinicalRecordMapper() { /* util */ }

    public static ClinicalRecord toDomain(ClinicalRecordEntity entity) {
        if (entity == null) return null;

        ClinicalRecord domain = new ClinicalRecord();

        domain.setDocument(entity.getDocument() != null ? entity.getDocument() : 0L);
        domain.setName(entity.getName() != null ? PatientMapper.toDomain(entity.getName()) : null);
        domain.setDoctorName(entity.getDoctorName() != null ? UserMapper.toDomain(entity.getDoctorName()) : null);
        domain.setDate(entity.getDate() != null ? (Date) entity.getDate() : null);
        domain.setMotive(entity.getMotive());
        domain.setDiagnosis(entity.getDiagnosis());
        domain.setMedicine(entity.getMedicine());
        domain.setMedicalProcedure(entity.getMedicalProcedure());
        domain.setDoce(entity.getDoce());
        domain.setClinicalOrder(entity.getClinicalOrder() != null ? ClinicalOrderMapper.toDomain(entity.getClinicalOrder()) : null);
        domain.setVaccinationRecord(entity.getVaccinationRecord());
        domain.setAllergies(entity.getAllergies());
        domain.setProceddureDetail(entity.getProceddureDetail());
        domain.setSymptoms(entity.getSymptoms());
        domain.setStatus(entity.getStatus() != null ? entity.getStatus() : false);

        // Nota: el dominio no tiene id explícito en tu clase; si lo tuviera, lo mapearíamos aquí.
        return domain;
    }

    public static ClinicalRecordEntity toEntity(ClinicalRecord domain) {
        if (domain == null) return null;

        ClinicalRecordEntity entity = new ClinicalRecordEntity();

        // document
        entity.setDocument(domain.getDocument());

        // relaciones
        Patient patientDomain = domain.getName();
        if (patientDomain != null) {
            PatientEntity pe = PatientMapper.toEntity(patientDomain);
            entity.setName(pe);
        } else {
            entity.setName(null);
        }

        User doctorDomain = domain.getDoctorName();
        if (doctorDomain != null) {
            UserEntity ue = UserMapper.toEntity(doctorDomain);
            entity.setDoctorName(ue);
        } else {
            entity.setDoctorName(null);
        }

        entity.setDate(domain.getDate() != null ? (Date) domain.getDate() : null);
        entity.setMotive(domain.getMotive());
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setMedicine(domain.getMedicine());
        entity.setMedicalProcedure(domain.getMedicalProcedure());
        entity.setDoce(domain.getDoce());

        ClinicalOrder co = domain.getClinicalOrder();
        if (co != null) {
            ClinicalOrderEntity ce = ClinicalOrderMapper.toEntity(co);
            entity.setClinicalOrder(ce);
        } else {
            entity.setClinicalOrder(null);
        }

        entity.setVaccinationRecord(domain.getVaccinationRecord());
        entity.setAllergies(domain.getAllergies());
        entity.setProceddureDetail(domain.getProceddureDetail());
        entity.setSymptoms(domain.getSymptoms());
        entity.setStatus(domain.isStatus());

        return entity;
    }

    /**
     * Actualiza una entidad existente a partir del dominio (útil en update).
     * No modifica id por defecto.
     */
    public static void updateEntityFromDomain(ClinicalRecordEntity entity, ClinicalRecord domain) {
        if (entity == null || domain == null) return;

        entity.setDocument(domain.getDocument());

        // patient
        if (domain.getName() != null) {
            entity.setName(PatientMapper.toEntity(domain.getName()));
        } else {
            entity.setName(null);
        }

        // doctor
        if (domain.getDoctorName() != null) {
            entity.setDoctorName(UserMapper.toEntity(domain.getDoctorName()));
        } else {
            entity.setDoctorName(null);
        }

        entity.setDate(domain.getDate());
        entity.setMotive(domain.getMotive());
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setMedicine(domain.getMedicine());
        entity.setMedicalProcedure(domain.getMedicalProcedure());
        entity.setDoce(domain.getDoce());

        if (domain.getClinicalOrder() != null) {
            entity.setClinicalOrder(ClinicalOrderMapper.toEntity(domain.getClinicalOrder()));
        } else {
            entity.setClinicalOrder(null);
        }

        entity.setVaccinationRecord(domain.getVaccinationRecord());
        entity.setAllergies(domain.getAllergies());
        entity.setProceddureDetail(domain.getProceddureDetail());
        entity.setSymptoms(domain.getSymptoms());
        entity.setStatus(domain.isStatus());
    }
}