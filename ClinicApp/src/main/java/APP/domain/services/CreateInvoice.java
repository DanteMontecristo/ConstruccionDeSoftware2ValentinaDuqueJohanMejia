package APP.domain.services;

import APP.domain.repository.ClinicalOrderPort;
import APP.domain.repository.PatientPort;
import APP.domain.repository.InvoicePort;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.Invoice;
import APP.domain.model.Patient;

public class CreateInvoice {

    private PatientPort patientPort;
    private ClinicalOrderPort clinicalOrderPort;
    private InvoicePort invoicePort;

    public void create(Invoice invoice) throws Exception {
        Patient posiblePatient = new Patient();
        posiblePatient.setDocument(invoice.getDocument());
        Patient patient = patientPort.findByDocument(posiblePatient); // tipo paciente y no tipo cedula
        if (patient == null){
            throw new Exception("La factura debe tener un paciente asociado");
        }
        if (invoice.isMedicine()){
            ClinicalOrder clinicalOrder = clinicalOrderPort.findByDocument(invoice.getOrder());
            if (clinicalOrder == null || patient.getDocument() != clinicalOrder.getPatientName().getDocument()) {
                throw new Exception("El medicamento requiere de una orden asociada");
            }
            invoice.setOrder(clinicalOrder);
        }
        invoice.setPatientName(patient);
        invoicePort.save(invoice);
    }
}
