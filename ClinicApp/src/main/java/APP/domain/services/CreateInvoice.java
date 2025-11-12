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

    public void createInvoice(Invoice invoice) throws Exception {
        Patient posiblePatient = new Patient();
        posiblePatient.setDocument(invoice.getDocument());
        Patient patient = patientPort.findByDocument(posiblePatient); // tipo paciente y no tipo cedula
        if (patient == null){
            throw new Exception("La factura debe tener un paciente asociado");
        }
        if (invoice.isMedicine()){
            ClinicalOrder clinicalOrder = clinicalOrderPort.findByDocument(invoice.getOrder());
            if (clinicalOrder == null || patient.getDocument() != clinicalOrder.getName().getDocument()) {
                throw new Exception("El medicamento requiere de una orden asociada");
            }
            invoice.setOrder(clinicalOrder);
        }
        invoice.setName(patient);
        invoicePort.save(invoice);
    }
}
