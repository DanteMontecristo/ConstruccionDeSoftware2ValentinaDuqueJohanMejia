package APP.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import APP.domain.model.Patient;
import APP.domain.ports.PatientPort;
import APP.infrastructure.persistence.entities.PatientEntity;
import APP.infrastructure.persistence.mapper.PatientMapper;
import APP.infrastructure.persistence.repository.PatientRepository;


@Service
public class PatientAdapter implements PatientPort {
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public void save(Patient patient) throws Exception {
		PatientEntity patientEntity = PatientMapper.toEntity(patient);
		patientRepository.save(patientEntity);		
	}

	@Override
	public Patient findByDocument(Patient patient) throws Exception {
		
		PatientEntity patientEntity = patientRepository.findByDocument(patient.getDocument());
		return PatientMapper.toDomain(patientEntity);
	}
	
}
