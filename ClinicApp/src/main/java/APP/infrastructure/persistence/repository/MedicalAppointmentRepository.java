package APP.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import APP.infrastructure.persistence.entities.MedicalAppointmentEntity;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointmentEntity, Long> {

}
