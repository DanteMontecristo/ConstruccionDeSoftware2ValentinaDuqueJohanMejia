package APP.application.port.in.builder;

import APP.domain.model.Invoice;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.application.port.in.validators.InvoiceValidator;
import APP.domain.model.ClinicalOrder;

public class InvoiceBuilder {

    private InvoiceValidator invoiceValidator;
    private Patient patient;
    
    public Invoice build(String document, String patientName, String doctorName, String insuranceCompany, String policyNumber, String policyValidity, String policyEndingDate, String medicine, String productName, String order) throws Exception{
        Invoice invoice = new Invoice();
        User name = new User();
        invoice.setDocument(invoiceValidator.documentValidator(document));
        patient.setPatientName(invoiceValidator.patientNameValidator(patientName));
        name.setName(invoiceValidator.doctorNameValidator(doctorName));
        invoice.setInsuranceCompany(invoiceValidator.insuranceCompanyValidator(insuranceCompany));
        invoice.setPolicyNumber(invoiceValidator.policyNumberValidator(policyNumber));
        invoice.setPolicyValidity(invoiceValidator.policyValidityValidator(policyValidity));
        invoice.setPolicyEndingDate(invoiceValidator.policyEndingDateValidator(policyEndingDate));
        invoice.setProductName(invoiceValidator.productNameValidator(productName));
        if (invoice.isMedicine()) {
			ClinicalOrder clinicalOrder = new ClinicalOrder();
			clinicalOrder.setId(invoiceValidator.orderIdValidator(order));
			invoice.setOrder(clinicalOrder);
		}

        return invoice;      
    }

}
