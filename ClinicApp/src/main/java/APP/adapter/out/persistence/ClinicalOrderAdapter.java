package APP.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.ports.ClinicalOrderPort;
import APP.infrastructure.persistence.entities.ClinicalOrderEntity;
import APP.infrastructure.persistence.mapper.ClinicalOrderMapper;
import APP.infrastructure.persistence.mapper.PatientMapper;
import APP.infrastructure.persistence.repository.ClinicalOrderRepository;

@Service
public class ClinicalOrderAdapter implements ClinicalOrderPort {
	@Autowired
	private ClinicalOrderRepository clinicalOrderRepository;

	@Override
	public ClinicalOrder findByDocument(ClinicalOrder clinicalOrder) throws Exception {
		ClinicalOrderEntity clinicalOrderEntity = clinicalOrderRepository.findById(clinicalOrder.getId());
		return ClinicalOrderMapper.toDomain(clinicalOrderEntity);
	}

	@Override
	public List<ClinicalOrder> findByPatient(Patient patient) throws Exception {
		List<ClinicalOrder> clinicalOrders = new ArrayList<ClinicalOrder>();
		List<ClinicalOrderEntity> clinicalOrdersEntities = clinicalOrderRepository.findByPatient(PatientMapper.toEntity(patient));
		for (ClinicalOrderEntity entity : clinicalOrdersEntities) {
			clinicalOrders.add(ClinicalOrderMapper.toDomain(entity));
		}
		return clinicalOrders;
	}

	@Override
	public void save(ClinicalOrder clinicalOrder) throws Exception {
		clinicalOrderRepository.save(ClinicalOrderMapper.toEntity(clinicalOrder));
		
	}

}
