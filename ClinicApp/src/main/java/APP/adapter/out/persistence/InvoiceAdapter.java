package APP.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import APP.domain.model.Invoice;
import APP.domain.ports.InvoicePort;
import APP.infrastructure.persistence.entities.InvoiceEntity;
import APP.infrastructure.persistence.entities.PatientEntity;
import APP.infrastructure.persistence.entities.UserEntity;
import APP.infrastructure.persistence.entities.ClinicalOrderEntity;
import APP.infrastructure.persistence.mapper.InvoiceMapper;
import APP.infrastructure.persistence.mapper.PatientMapper;
import APP.infrastructure.persistence.mapper.UserMapper;
import APP.infrastructure.persistence.repository.InvoiceRepository;
import APP.infrastructure.persistence.repository.PatientRepository;
import APP.infrastructure.persistence.repository.UserRepository;
import APP.infrastructure.persistence.repository.ClinicalOrderRepository;

@Service
public class InvoiceAdapter implements InvoicePort {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceAdapter.class);

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClinicalOrderRepository clinicalOrderRepository;

	@Override
	public void save(Invoice invoice) throws Exception {
		try {
			logger.info("Guardando Invoice: paciente={}, medicine={}", 
				invoice.getDocument(), invoice.isMedicine());
			
			// Convertir dominio -> entity
			InvoiceEntity entity = InvoiceMapper.toEntity(invoice);

			// Reemplazar patient con entidad gestionada si existe
			if (invoice.getName() != null) {
				PatientEntity managedPatient = patientRepository.findByDocument(invoice.getName().getDocument());
				if (managedPatient != null) {
					entity.setPatient(managedPatient);
				} else {
					// Si no existe, persistir el paciente primero
					PatientEntity newPatient = PatientMapper.toEntity(invoice.getName());
					managedPatient = patientRepository.save(newPatient);
					entity.setPatient(managedPatient);
				}
			}

			// Reemplazar doctor con entidad gestionada si existe
			if (invoice.getDoctorName() != null) {
				UserEntity managedDoctor = userRepository.findByDocument(invoice.getDoctorName().getDocument());
				if (managedDoctor != null) {
					entity.setDoctorName(managedDoctor);
				} else {
					// Si no existe, persistir el doctor primero (mínimo necesario)
					UserEntity newDoctor = UserMapper.toEntity(invoice.getDoctorName());
					managedDoctor = userRepository.save(newDoctor);
					entity.setDoctorName(managedDoctor);
				}
			}

			// Reemplazar order con entidad gestionada si existe
			if (invoice.getOrder() != null && invoice.getOrder().getId() != 0L) {
				ClinicalOrderEntity managedOrder = clinicalOrderRepository.findById(invoice.getOrder().getId());
				if (managedOrder != null) {
					entity.setOrder(managedOrder);
				}
				// Si no existe, la validación en CreateInvoice ya lo habría lanzado, así que no hacer nada
			}

			invoiceRepository.save(entity);
			logger.info("✅ Invoice guardado exitosamente");
		} catch (Exception e) {
			logger.error("❌ Error guardando Invoice: {}", e.getMessage(), e);
			throw e;
		}
	}

}
