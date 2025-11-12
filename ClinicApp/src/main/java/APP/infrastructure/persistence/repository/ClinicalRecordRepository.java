package APP.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import APP.infrastructure.persistence.entities.ClinicalRecordEntity;

@Repository
public interface ClinicalRecordRepository extends JpaRepository<ClinicalRecordEntity, Long>{

}
