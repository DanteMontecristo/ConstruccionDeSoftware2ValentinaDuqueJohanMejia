package APP.application.port.in;

import java.util.Scanner;

import APP.application.usecase.AdministrativeStaffUseCase;
import APP.domain.model.Patient;

public class AdministrativeStaff {

    private static final String MENU = "Ingrese una de las opciones" +
    "\n 1. Crear paciente" +
    "\n 2. Actualizar paciente" +
    "\n 3. Crear cita" +
    "\n 4. Crear factura" +
    "\n 5. Salir";
	private static Scanner reader = new Scanner(System.in);

    private AdministrativeStaffUseCase administrativeStaffUseCase;

    public void session() {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    private boolean menu(){
        try {
            System.out.println(MENU);
            String option = reader.nextLine();
            switch (option) {
                case "1":
                    Patient patient = readInfoFromPatient();
                    administrativeStaffUseCase.createPatient(patient);
                    return true;
                case "2":
                    Patient patientToUpdate = readInfoFromPatient();
                    administrativeStaffUseCase.update(patientToUpdate);
                    return true;
                case "3":
                    Patient patientForAppointment = readInfoFromPatient();
                    administrativeStaffUseCase.createMedicalAppointment(patientForAppointment);
                    return true;
                case "4":
                
            
                default:
                    break;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
