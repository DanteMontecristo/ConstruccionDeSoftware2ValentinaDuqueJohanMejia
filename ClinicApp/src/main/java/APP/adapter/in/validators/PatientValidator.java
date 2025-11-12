package APP.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class PatientValidator extends SimpleValidator{

    public String nameValidator(String value) throws Exception{
        return stringValidator("Nombre del paciente", value);
    }

    public Long documentValidator(String value) throws Exception{
        return longValidator("Documento del paciente",value);
    }
    public int ageValidator(String value) throws Exception{
        return intergerValidator("Edad del paciente", value);
    }

    public String genderValidator(String value) throws Exception{
        return stringValidator("Genero del paciente", value);
    }

    public String addressValidator(String value) throws Exception{
        return stringValidator("Direccion del paciente", value);
    }

    public String phoneNumberValidator(String value) throws Exception{
        return stringValidator("Numero de telefono del paciente", value);
    }

    public String emailValidator(String value) throws Exception{
        return stringValidator("Email del paciente", value);
    }

}
