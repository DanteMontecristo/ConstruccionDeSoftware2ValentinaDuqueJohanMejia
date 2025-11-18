package APP.adapter.in.validators;

import org.springframework.stereotype.Component;
import APP.domain.model.Patient;

@Component
public class InvoiceValidator extends SimpleValidator{

    public String productNameValidator(String value) throws Exception {
        return stringValidator("nombre del producto", value);
    }

    public boolean isMedicineValidator(String value) throws Exception {
		stringValidator("venta de medicina", value);
		// Case-insensitive check for SI/si/Yes/yes
		return value != null && (value.equalsIgnoreCase("si") || value.equalsIgnoreCase("yes"));
	}

    public String nameValidator(String value) throws Exception{
        return stringValidator("Nombre del paciente", value);
    }

    public Long documentValidator(String value) throws Exception{
        return longValidator("Documento del paciente",value);
    }
    
    public String doctorNameValidator(String value) throws Exception{
        return stringValidator("Nombre del doctor", value);
    }

    public String insuranceCompanyValidator(String value) throws Exception{
        return stringValidator("Nombre de la compañia de seguros", value);
    }

    public String policyNumberValidator(String value) throws Exception{
        return stringValidator("Numero de la poliza", value);
    }

    public String policyValidityValidator(String value) throws Exception{
        return stringValidator("Vigencia de la poliza", value);
    }

    public String policyEndingDateValidator(String value) throws Exception{
        return stringValidator("Fecha de vencimiento de la poliza", value);
    }

    public String orderValidator(String value) throws Exception{
        return stringValidator("Orden medica", value);
    }

    public String idvalidator(String value) throws Exception{
        return stringValidator("Id de la orden clinica", value);
    }

    public long orderIdValidator(String value) throws Exception {
		return longValidator("id de la orden", value);
	}

    public String nameValidator(Patient name) {
        throw new UnsupportedOperationException();
    }

}


