package APP.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.adapter.in.builder.ClinicalOrderBuilder;
import APP.adapter.rest.request.ClinicalOrderRequest;
import APP.adapter.rest.response.ClinicalOrderResponse;
import APP.domain.model.ClinicalOrder;

@Component
public class ClinicalOrderRestMapper {
    
    @Autowired
    private ClinicalOrderBuilder clinicalOrderBuilder;

    public ClinicalOrder toDomain(ClinicalOrderRequest req) throws Exception {
        return clinicalOrderBuilder.build(
            req.getDoctorDocument(),
            req.getPatientDocument(),
            req.getMedicine(),
            req.getDoce(),
            req.getDate()
        );
    }

    public ClinicalOrderResponse toResponse(ClinicalOrder order) {
        ClinicalOrderResponse res = new ClinicalOrderResponse();
        res.setId(order.getId());
        res.setPatientDocument(order.getName() != null ? order.getName().getDocument() : 0);
        res.setDoctorDocument(order.getDoctorName() != null ? order.getDoctorName().getDocument() : 0);
        res.setMedicine(order.getMedicine());
        res.setDoce(order.getDoce());
        res.setDate(order.getDate());
        return res;
    }

}