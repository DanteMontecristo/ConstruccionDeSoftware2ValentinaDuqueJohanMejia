package APP.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import APP.domain.model.Visit;
import APP.domain.ports.VisitPort;
import APP.infrastructure.persistence.entities.UserEntity;
import APP.infrastructure.persistence.mapper.VisitMapper;
import APP.infrastructure.persistence.repository.UserRepository;
import APP.infrastructure.persistence.repository.VisitRepository;

@Service
public class VisitAdapter implements VisitPort {

    @Autowired
    private VisitRepository visitRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(Visit visit) throws Exception {
        APP.infrastructure.persistence.entities.VisitEntity entity = VisitMapper.toEntity(visit);
        
        System.out.println("VisitAdapter: persisting visit with document=" + entity.getDocument() 
                          + ", visitName=" + entity.getVisitName() 
                          + ", userName=" + (entity.getName() != null ? entity.getName().getUserName() : "null"));
        
        // Si tiene usuario, buscar la instancia gestionada en BD
        if (entity.getName() != null) {
            UserEntity managedUser = userRepository.findByUserName(entity.getName().getUserName());
            if (managedUser != null) {
                entity.setName(managedUser);
                System.out.println("VisitAdapter: usuario encontrado en BD, usando instancia gestionada");
            } else {
                System.out.println("VisitAdapter: usuario no encontrado, dejando como null");
                entity.setName(null);
            }
        }
        
        visitRepository.save(entity);
        
        System.out.println("✓ Visita registrada con id=" + entity.getId());
    }
}
