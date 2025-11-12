package APP.infrastructure.persistence.mapper;

import APP.domain.model.Invoice;
import APP.infrastructure.persistence.entities.InvoiceEntity;

public class InvoiceMapper {

    public static InvoiceEntity toEntity(Invoice invoice) {
        if (invoice == null) return null;

        InvoiceEntity entity = new InvoiceEntity();
        entity.setDocument(invoice.getDocument());
        entity.setName(PatientMapper.toEntity(invoice.getName()));
        entity.setDoctorName(UserMapper.toEntity(invoice.getDoctorName()));
        entity.setInsuranceCompany(invoice.getInsuranceCompany());
        entity.setPolicyNumber(invoice.getPolicyNumber());
        entity.setPolicyValidity(invoice.getPolicyValidity());
        entity.setPolicyEndingDate(invoice.getPolicyEndingDate());
        entity.setMedicine(invoice.isMedicine());
        entity.setOrder(ClinicalOrderMapper.toEntity(invoice.getOrder()));
        entity.setProductName(invoice.getProductName());
        return entity;
    }

    public static Invoice toDomain(InvoiceEntity entity) {
        if (entity == null) return null;

        Invoice invoice = new Invoice();
        invoice.setDocument(entity.getDocument());
        invoice.setName(PatientMapper.toDomain(entity.getName()));
        invoice.setDoctorName(UserMapper.toDomain(entity.getDoctorName()));
        invoice.setInsuranceCompany(entity.getInsuranceCompany());
        invoice.setPolicyNumber(entity.getPolicyNumber());
        invoice.setPolicyValidity(entity.getPolicyValidity());
        invoice.setPolicyEndingDate(entity.getPolicyEndingDate());
        invoice.setMedicine(entity.isMedicine());
        invoice.setOrder(ClinicalOrderMapper.toDomain(entity.getOrder()));
        invoice.setProductName(entity.getProductName());
        return invoice;
    }
}