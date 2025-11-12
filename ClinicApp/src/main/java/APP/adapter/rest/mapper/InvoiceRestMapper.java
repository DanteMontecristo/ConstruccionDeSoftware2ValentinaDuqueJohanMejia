package APP.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.adapter.in.builder.InvoiceBuilder;
import APP.adapter.rest.request.InvoiceRequest;
import APP.adapter.rest.response.InvoiceResponse;
import APP.domain.model.Invoice;

@Component
public class InvoiceRestMapper {


    @Autowired
    private InvoiceBuilder invoiceBuilder;

    public Invoice toDomain(InvoiceRequest req) throws Exception {
        return invoiceBuilder.build(
            req.getDocument(),
            req.getName(), 
            req.getDoctorName(),
            req.getInsuranceCompany(),
            req.getPolicyNumber(),
            req.getPolicyValidity(),
            req.getPolicyEndingDate(),
            req.getIsMedicine(),
            req.getProductName(),
            req.getOrder()
        );
    }

    public InvoiceResponse toResponse(Invoice invoice) {
        InvoiceResponse res = new InvoiceResponse();
        res.setProductName(invoice.getProductName());
        res.setName(invoice.getName());
        res.setDocument(invoice.getDocument());
        res.setDoctorName(invoice.getDoctorName());
        res.setInsuranceCompany(invoice.getInsuranceCompany());
        res.setPolicyNumber(invoice.getPolicyNumber());
        res.setPolicyValidity(invoice.getPolicyValidity());
        res.setPolicyEndingDate(invoice.getPolicyEndingDate());
        res.setisMedicine(invoice.isMedicine());
        res.setOrder(invoice.getOrder());
        return res;
    }
}