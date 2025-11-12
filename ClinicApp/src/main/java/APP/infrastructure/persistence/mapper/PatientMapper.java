package APP.infrastructure.persistence.mapper;


import APP.domain.model.Patient;
import APP.infrastructure.persistence.entities.PatientEntity;

/**
 * Mapper simple entre PatientEntity <-> Patient (dominio).
 * - Métodos estáticos para uso directo desde repositorio/servicio.
 * - No usa librerías externas; si prefieres, podemos migrar a MapStruct.
 */
public final class PatientMapper {

    private PatientMapper() { /* util class */ }

    /**
     * Convierte Entity -> Domain
     */
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        Patient domain = new Patient();

        // Si tu modelo de dominio tiene Long id o no, ajusta. Aquí uso los campos que mostraste.
        // document/age en domain podían ser primitivos; manejamos nulls con defaults si hace falta.
        if (entity.getDocument() != null) {
            domain.setDocument(entity.getDocument()); // si domain usa long primitivo, se autounboxea
        } else {
            domain.setDocument(0L);
        }

        domain.setName(entity.getName());
        domain.setGender(entity.getGender());
        domain.setAddress(entity.getAddress());
        domain.setPhoneNumber(entity.getPhoneNumber());
        domain.setEmail(entity.getEmail());

        if (entity.getAge() != null) {
            domain.setAge(entity.getAge()); // Integer -> int (autounbox)
        } else {
            domain.setAge(0);
        }

        return domain;
    }

    /**
     * Convierte Domain -> Entity (nuevo objeto)
     */
    public static PatientEntity toEntity(Patient domain) {
        if (domain == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();

        // No seteamos id aquí (lo maneja JPA al persistir). Si quieres mantener id, añade getter en domain.
        entity.setDocument(domain.getDocument());
        entity.setName(domain.getName());
        entity.setAge(domain.getAge()); // int -> Integer (autobox)
        entity.setGender(domain.getGender());
        entity.setAddress(domain.getAddress());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setEmail(domain.getEmail());

        return entity;
    }

    /**
     * Actualiza una entidad existente con los datos del dominio (útil para update/PUT).
     * No modifica id ni campos que quieras mantener inmutables.
     */
    public static void updateEntityFromDomain(PatientEntity entity, Patient domain) {
        if (entity == null || domain == null) {
            return;
        }

        // Si document es inmutable, omitir la siguiente línea
        entity.setDocument(domain.getDocument());
        entity.setName(domain.getName());
        entity.setAge(domain.getAge());
        entity.setGender(domain.getGender());
        entity.setAddress(domain.getAddress());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setEmail(domain.getEmail());
    }
}