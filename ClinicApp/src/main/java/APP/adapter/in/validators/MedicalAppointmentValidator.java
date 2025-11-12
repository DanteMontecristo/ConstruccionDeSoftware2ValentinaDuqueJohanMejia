package APP.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class MedicalAppointmentValidator extends SimpleValidator{

    public String dateValidator(String value) throws Exception{
        return stringValidator("Fecha de la cita", value);
    }

    public String timeValidator(String value) throws Exception{
        return stringValidator("Hora de la cita", value);
    }

    public String reasonValidator(String value) throws Exception{
        return stringValidator("Razon de la cita", value);
    }
    
    public String patientNameValidator(String value) throws Exception{
        return stringValidator("Para quien es la cita", value);
    }
    
    public String doctorNameValidator(String value) throws Exception{
        return stringValidator("Con quien es la cita", value);
    }
    
}
