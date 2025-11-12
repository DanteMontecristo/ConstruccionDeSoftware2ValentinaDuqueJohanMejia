package APP.adapter.in.builder;

import APP.domain.model.Invoice;
import APP.domain.model.Patient;
import APP.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.adapter.in.validators.InvoiceValidator;
import APP.domain.model.ClinicalOrder;

@Component
public class InvoiceBuilder {

    @Autowired
    private InvoiceValidator invoiceValidator;
    
    public Invoice build(String document, String name, String doctorName, String insuranceCompany, String policyNumber, String policyValidity, String policyEndingDate, String medicine, String productName, String order) throws Exception{
        Invoice invoice = new Invoice();
        Patient patient = new Patient();
        User user = new User();
        invoice.setDocument(invoiceValidator.documentValidator(document));
        patient.setName(invoiceValidator.nameValidator(name));
        user.setName(invoiceValidator.doctorNameValidator(doctorName));
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
