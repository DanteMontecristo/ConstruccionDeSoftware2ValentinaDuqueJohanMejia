package APP.domain.repository;

import APP.domain.model.Invoice;

public interface InvoicePort {
    
    public void save(Invoice invoice) throws Exception;
    
}
