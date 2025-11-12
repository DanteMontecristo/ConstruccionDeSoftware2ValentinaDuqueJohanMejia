package APP.adapter.out.persistence;

import org.springframework.stereotype.Service;
import APP.domain.model.Invoice;
import APP.domain.ports.InvoicePort;

@Service
public class InvoiceAdapter implements InvoicePort {

	@Override
	public void save(Invoice invoice) throws Exception {
		System.out.println("se ha guardado la factura");
	}

}
