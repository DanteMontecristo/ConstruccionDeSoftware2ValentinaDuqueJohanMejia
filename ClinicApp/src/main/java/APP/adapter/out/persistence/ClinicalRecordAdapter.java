package APP.adapter.out.persistence;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.ports.ClinicalRecordPort;
import APP.infrastructure.persistence.entities.ClinicalRecordEntity;
import APP.infrastructure.persistence.mapper.ClinicalRecordMapper;
import APP.infrastructure.persistence.repository.ClinicalRecordRepository;

@Service
public class ClinicalRecordAdapter implements ClinicalRecordPort {
	
	@Autowired
	private ClinicalRecordRepository clinicalRecordRepository;

	@Override
	public void save(ClinicalRecord clinicalRecord) throws Exception {
		ClinicalRecordEntity entity = ClinicalRecordMapper.toEntity(clinicalRecord);
		clinicalRecordRepository.save(entity);
	}

	@Override
	public List<ClinicalRecord> findByPatient(Patient patient) throws Exception {
		return null;
	}

    @Override
    public Patient findByPatient(ClinicalRecord clinicalRecord) {
        throw new UnsupportedOperationException();
    }

}
