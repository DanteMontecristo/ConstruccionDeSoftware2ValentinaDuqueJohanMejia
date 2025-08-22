package APP.domain.services;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Invoice;
import APP.domain.model.Patient;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.InvoicePort;
import APP.domain.ports.PatientPort;

public class CreateInvoice {
    private PatientPort patientPort;
	private ClinicalOrderPort clinicalOrderPort;
	private InvoicePort invoicePort;
	
	public void create(Invoice invoice) throws Exception {
		Patient patient = patientPort.findById(invoice.getPatientName());
		if(patient == null) {
			throw new Exception("la factura debe tener un paciente asociado");
		}
		if(invoice.isMedicine()) {
			ClinicalOrder clinicalOrder = clinicalOrderPort.findByDocument(invoice.getOrder());
			if(clinicalOrder==null || patient.getAge()!=((Invoice) clinicalOrder.getPatientName()).getDocument()) {
				throw new Exception ("la venta de un medicamento requiere de una orden asociada");
			}
			invoice.setOrder(clinicalOrder);
		}
		invoicePort.save(invoice);
	}
}
