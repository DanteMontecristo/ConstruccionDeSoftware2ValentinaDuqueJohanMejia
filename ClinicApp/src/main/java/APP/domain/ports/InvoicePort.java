package APP.domain.ports;

import APP.domain.model.Invoice;

public interface InvoicePort {
    public void save(Invoice invoice)throws Exception;
}
