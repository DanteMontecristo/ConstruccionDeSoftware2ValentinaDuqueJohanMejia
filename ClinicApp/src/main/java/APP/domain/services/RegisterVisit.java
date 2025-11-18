package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import APP.domain.model.Patient;
import APP.domain.model.Visit;
import APP.domain.ports.PatientPort;
import APP.domain.ports.VisitPort;

@Component
public class RegisterVisit {

    private static final Logger logger = LoggerFactory.getLogger(RegisterVisit.class);
    
    @Autowired
    private PatientPort patientPort;
    
    @Autowired
    private VisitPort visitPort;

    public void registerVisit(Visit visit) throws Exception {
        logger.info("RegisterVisit: registrando visita para paciente document={} visitName={}", 
                    visit != null ? visit.getDocument() : null, 
                    visit != null ? visit.getVisitName() : null);
        
        if (visit == null) {
            throw new Exception("La visita no puede ser nula");
        }
        
        // Crear un Patient temporal solo para verificar que existe
        Patient patient = new Patient();
        patient.setDocument(visit.getDocument());
        
        Patient foundPatient = patientPort.findByDocument(patient);
        if (foundPatient == null) {
            logger.warn("RegisterVisit: paciente no encontrado con documento={}", visit.getDocument());
            throw new Exception("No existe un paciente registrado con esa cedula");
        }
        
        // Persistir la visita (no el paciente)
        visitPort.save(visit);
        logger.info("RegisterVisit: visita registrada exitosamente");
    }
}
