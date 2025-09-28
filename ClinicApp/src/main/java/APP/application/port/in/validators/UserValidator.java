package APP.application.port.in.validators;

import APP.domain.model.enums.Role;

public class UserValidator extends SimpleValidator {

    public String nameValidator (String value) throws Exception {
        return stringValidator("nombre de la persona", value);
    }

    public String userNameValidator (String value) throws Exception {
        return stringValidator("nombre de usuario", value);
    }

    public String passwordValidator (String value) throws Exception {
        return stringValidator("contraseña", value);
    }

    public long documentValidator (String value) throws Exception {
        return longValidator("documento de la persona", value);
    }

    public int ageValidator(String value) throws Exception {
        return intergerValidator("edad de la persona", value);
    }

    public String emailValidator (String value) throws Exception {
        return stringValidator("email de la persona", value);
    }
    
    public String phoneNumberValidator (String value) throws Exception {
        return stringValidator("numero de telefono de la persona", value);
    }
    
    public String addressValidator (String value) throws Exception {
        return stringValidator("direccion de la persona", value);
    }

    public Role roleValidator (String value) throws Exception {
        return roleValidator(value);
    }

}
