package APP.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.ports.ClinicalOrderPort;
import APP.infrastructure.persistence.entities.ClinicalOrderEntity;
import APP.infrastructure.persistence.entities.PatientEntity;
import APP.infrastructure.persistence.entities.UserEntity;
import APP.infrastructure.persistence.mapper.ClinicalOrderMapper;
import APP.infrastructure.persistence.mapper.PatientMapper;
import APP.infrastructure.persistence.repository.ClinicalOrderRepository;
import APP.infrastructure.persistence.repository.PatientRepository;
import APP.infrastructure.persistence.repository.UserRepository;

@Service
public class ClinicalOrderAdapter implements ClinicalOrderPort {
	@Autowired
	private ClinicalOrderRepository clinicalOrderRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public ClinicalOrder findByDocument(ClinicalOrder clinicalOrder) throws Exception {
		ClinicalOrderEntity clinicalOrderEntity = clinicalOrderRepository.findById(clinicalOrder.getId());
		return ClinicalOrderMapper.toDomain(clinicalOrderEntity);
	}

	@Override
	public List<ClinicalOrder> findByPatient(Patient patient) throws Exception {
		List<ClinicalOrder> clinicalOrders = new ArrayList<ClinicalOrder>();
		// Obtener entidad gestionada del paciente por documento para la consulta
		PatientEntity patientEntity = null;
		if (patient != null) {
			patientEntity = patientRepository.findByDocument(patient.getDocument());
		}
		List<ClinicalOrderEntity> clinicalOrdersEntities = clinicalOrderRepository.findByPatient(patientEntity);
		for (ClinicalOrderEntity entity : clinicalOrdersEntities) {
			clinicalOrders.add(ClinicalOrderMapper.toDomain(entity));
		}
		return clinicalOrders;
	}

	@Override
	public void save(ClinicalOrder clinicalOrder) throws Exception {
		// Convertir dominio -> entity
		ClinicalOrderEntity entity = ClinicalOrderMapper.toEntity(clinicalOrder);

		// Reemplazar patient con la entidad gestionada si existe (evita TransientObjectException)
		if (clinicalOrder.getName() != null) {
			PatientEntity managedPatient = patientRepository.findByDocument(clinicalOrder.getName().getDocument());
			if (managedPatient != null) {
				entity.setPatient(managedPatient);
			} else {
				// Si no existe, persistir el paciente primero
				PatientEntity newPatient = PatientMapper.toEntity(clinicalOrder.getName());
				managedPatient = patientRepository.save(newPatient);
				entity.setPatient(managedPatient);
			}
		}

		// Reemplazar doctor con entidad gestionada si existe
		if (clinicalOrder.getDoctorName() != null) {
			UserEntity managedDoctor = userRepository.findByDocument(clinicalOrder.getDoctorName().getDocument());
			if (managedDoctor != null) {
				entity.setDoctorName(managedDoctor);
			} else {
				// map and save minimal doctor entity if necessary
				UserEntity newDoctor = APP.infrastructure.persistence.mapper.UserMapper.toEntity(clinicalOrder.getDoctorName());
				managedDoctor = userRepository.save(newDoctor);
				entity.setDoctorName(managedDoctor);
			}
		}

		clinicalOrderRepository.save(entity);
	}

}
