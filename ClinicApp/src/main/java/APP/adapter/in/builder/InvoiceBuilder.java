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
        
        // Validate and set document
        invoice.setDocument(invoiceValidator.documentValidator(document));
        
        // Validate and set patient with name and document
        patient.setDocument(invoiceValidator.documentValidator(document));
        patient.setName(invoiceValidator.nameValidator(name));
        invoice.setName(patient);
        
        // Validate and set doctor with name
        user.setName(invoiceValidator.doctorNameValidator(doctorName));
        invoice.setDoctorName(user);
        
        invoice.setInsuranceCompany(invoiceValidator.insuranceCompanyValidator(insuranceCompany));
        invoice.setPolicyNumber(invoiceValidator.policyNumberValidator(policyNumber));
        invoice.setPolicyValidity(invoiceValidator.policyValidityValidator(policyValidity));
        invoice.setPolicyEndingDate(invoiceValidator.policyEndingDateValidator(policyEndingDate));
        invoice.setProductName(invoiceValidator.productNameValidator(productName));
        
        // Validate and set medicine BEFORE checking it
        boolean isMedicine = invoiceValidator.isMedicineValidator(medicine);
        invoice.setMedicine(isMedicine);
        
        // If medicine, validate and set clinical order
        if (isMedicine) {
			ClinicalOrder clinicalOrder = new ClinicalOrder();
			clinicalOrder.setId(invoiceValidator.orderIdValidator(order));
			invoice.setOrder(clinicalOrder);
		}

        return invoice;      
    }

}
