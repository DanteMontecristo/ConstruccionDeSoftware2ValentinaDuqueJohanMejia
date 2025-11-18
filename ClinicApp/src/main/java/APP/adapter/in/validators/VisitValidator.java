package APP.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class VisitValidator extends SimpleValidator {

    public Long documentValidator(String value) throws Exception {
        return longValidator("Documento del paciente", value);
    }

    public String visitNameValidator(String value) throws Exception {
        return stringValidator("Nombre de la visita", value);
    }
}
