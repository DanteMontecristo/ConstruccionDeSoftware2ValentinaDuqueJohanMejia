package APP.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import APP.infrastructure.persistence.entities.VisitEntity;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

}
