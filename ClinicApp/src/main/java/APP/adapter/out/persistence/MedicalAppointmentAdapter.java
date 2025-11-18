package APP.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import APP.domain.model.MedicalAppointment;
import APP.domain.model.Patient;
import APP.domain.ports.MedicalAppointmentPort;
import APP.infrastructure.persistence.repository.PatientRepository;
import APP.infrastructure.persistence.repository.MedicalAppointmentRepository;
import APP.infrastructure.persistence.mapper.PatientMapper;

@Service
public class MedicalAppointmentAdapter implements MedicalAppointmentPort {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Override
    public Patient findByDocument(MedicalAppointment medicalAppointment) throws Exception {
        if (medicalAppointment == null || medicalAppointment.getPatientName() == null) return null;
        String name = medicalAppointment.getPatientName();
        // Buscar paciente por nombre (insensible a mayúsculas)
        APP.infrastructure.persistence.entities.PatientEntity pe = patientRepository.findByNameIgnoreCase(name);
        if (pe == null) return null;
        return PatientMapper.toDomain(pe);
    }

    @Override
    public void save(MedicalAppointment medicalAppointment) throws Exception {
        // Persistir la cita médica en la tabla `medical_appointments`
        APP.infrastructure.persistence.entities.MedicalAppointmentEntity entity = APP.infrastructure.persistence.mapper.MedicalAppointmentMapper.toEntity(medicalAppointment);
        medicalAppointmentRepository.save(entity);
        System.out.println("Cita médica persistida con id=" + entity.getId());
    }
}
