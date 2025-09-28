package APP.application.port.in.validators;

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
}
