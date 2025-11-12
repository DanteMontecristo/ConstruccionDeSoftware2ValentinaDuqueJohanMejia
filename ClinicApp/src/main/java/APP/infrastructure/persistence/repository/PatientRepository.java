package APP.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import APP.infrastructure.persistence.entities.PatientEntity;

 @Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    public PatientEntity findByDocument(long document);
   
}
