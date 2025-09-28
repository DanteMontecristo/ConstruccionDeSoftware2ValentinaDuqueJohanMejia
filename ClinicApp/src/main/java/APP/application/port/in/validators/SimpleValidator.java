package APP.application.port.in.validators;
import APP.application.exception.InputsException;
public class SimpleValidator {
    public String stringValidator(String element, String value) throws Exception{
        if(value == null || value.equals("")){
            throw new InputsException(element + " no puede ser nulo o vacio");
        }
        return value;
    }

    public int intergerValidator(String element, String value) throws Exception {
       stringValidator(element, value);
       try{
        int intValue = Integer.parseInt(value);
        return intValue;
         }catch(Exception e){
            throw new InputsException(element + " debe ser un numero numerico");
       }
    }

    public long longValidator(String element, String value) throws Exception {
		stringValidator(element, value);
		try {
			long longValue = Long.parseLong(value);
			return longValue;
		} catch (Exception e) {
			throw new InputsException(element + " debe ser un valor numerico");
		}
}
}