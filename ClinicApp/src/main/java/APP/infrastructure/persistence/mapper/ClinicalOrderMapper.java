package APP.infrastructure.persistence.mapper;

import APP.domain.model.ClinicalOrder;
import APP.infrastructure.persistence.entities.ClinicalOrderEntity;
import APP.infrastructure.persistence.entities.PatientEntity;
import APP.infrastructure.persistence.entities.UserEntity;

import java.sql.Date;

/**
 * Mapper entre ClinicalOrderEntity <-> APP.domain.model.ClinicalOrder
 *
 * Nota:
 * - Se asume que existen PatientEntityMapper y UserEntityMapper en este mismo paquete.
 * - El dominio usa tipos primitivos (long) para id/document; aquí tratamos 0L como "no seteado".
 */
public final class ClinicalOrderMapper {

    private ClinicalOrderMapper() { /* util */ }

    /**
     * Convierte Entity -> Domain
     */
    public static ClinicalOrder toDomain(ClinicalOrderEntity entity) {
        if (entity == null) {
            return null;
        }

        ClinicalOrder domain = new ClinicalOrder();

        // id y document en dominio son primitivos long: si la entidad tiene null devolvemos 0L
        domain.setId(entity.getId() != null ? entity.getId() : 0L);
        domain.setDocument(entity.getDocument() != null ? entity.getDocument() : 0L);

        // patient (usa PatientEntityMapper)
        PatientEntity patientEntity = entity.getPatient();
        if (patientEntity != null) {
            domain.setName(PatientMapper.toDomain(patientEntity));
        } else {
            domain.setName(null);
        }

        // doctor (usa UserEntityMapper)
        UserEntity doctorEntity = entity.getDoctorName();
        if (doctorEntity != null) {
            domain.setDoctorName(UserMapper.toDomain(doctorEntity));
        } else {
            domain.setDoctorName(null);
        }

        domain.setMedicine(entity.getMedicine());
        domain.setDoce(entity.getDoce());
        domain.setDate(entity.getDate() != null ? (Date) entity.getDate() : null);

        return domain;
    }

    /**
     * Convierte Domain -> Entity (nuevo objeto).
     * No setea el id a menos que el dominio lo tenga distinto de 0L.
     */
    public static ClinicalOrderEntity toEntity(ClinicalOrder domain) {
        if (domain == null) {
            return null;
        }

        ClinicalOrderEntity entity = new ClinicalOrderEntity();

        // id: solo setear si viene distinto de 0 (tu dominio usa long primitivo)
        if (domain.getId() != 0L) {
            entity.setId(domain.getId()); // autoboxing a Long
        }

        // document
        entity.setDocument(domain.getDocument()); // autoboxing a Long

        // patient
        if (domain.getName() != null) {
            entity.setPatient(PatientMapper.toEntity(domain.getName()));
        } else {
            entity.setPatient(null);
        }

        // doctor
        if (domain.getDoctorName() != null) {
            entity.setDoctorName(UserMapper.toEntity(domain.getDoctorName()));
        } else {
            entity.setDoctorName(null);
        }

        entity.setMedicine(domain.getMedicine());
        entity.setDoce(domain.getDoce());
        entity.setDate(domain.getDate()); // java.sql.Date

        return entity;
    }

    /**
     * Actualiza una entidad existente con los datos del dominio (útil para update/PUT).
     * No modifica el id por defecto.
     */
    public static void updateEntityFromDomain(ClinicalOrderEntity entity, ClinicalOrder domain) {
        if (entity == null || domain == null) {
            return;
        }

        // document (si quieres que sea inmutable, comenta esta línea)
        entity.setDocument(domain.getDocument());

        // actualizar patient
        if (domain.getName() != null) {
            entity.setPatient(PatientMapper.toEntity(domain.getName()));
        } else {
            entity.setPatient(null);
        }

        // actualizar doctor
        if (domain.getDoctorName() != null) {
            entity.setDoctorName(UserMapper.toEntity(domain.getDoctorName()));
        } else {
            entity.setDoctorName(null);
        }

        entity.setMedicine(domain.getMedicine());
        entity.setDoce(domain.getDoce());
        entity.setDate(domain.getDate());
    }
}