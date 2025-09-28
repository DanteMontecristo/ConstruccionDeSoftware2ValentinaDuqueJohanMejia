package APP.application.port.in;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import APP.application.usecase.AdministrativeStaffUseCase;
import APP.domain.model.MedicalAppointment;
import APP.domain.model.Patient;
import APP.application.port.in.builder.InvoiceBuilder;
import APP.application.port.in.builder.MedicalAppointmentBuilder;
import APP.application.port.in.builder.PatientBuilder;
import APP.domain.model.Invoice;

public class AdministrativeStaffClient {

    private static final String MENU = "Ingrese una de las opciones" +
    "\n 1. Crear paciente" +
    "\n 2. Actualizar paciente" +
    "\n 3. Crear cita" +
    "\n 4. Crear factura" +
    "\n 5. Salir";

	private static Scanner reader = new Scanner(System.in);

    private AdministrativeStaffUseCase administrativeStaffUseCase;

    @Autowired
    private PatientBuilder patientBuilder;

    @Autowired
    private MedicalAppointmentBuilder medicalAppointmentBuilder;

    @Autowired
    private InvoiceBuilder invoiceBuilder;

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
                    MedicalAppointment patientForAppointment = readInfoFromMedicalAppointment();
                    administrativeStaffUseCase.createMedicalAppointment(patientForAppointment);
                    return true;

                case "4":
                    Invoice invoiceForPatient = readInvoiceData();
                    administrativeStaffUseCase.createInvoice(invoiceForPatient);
                    return true;

                case "5":
                    System.out.println("¡Hasta luego!");
                    return false;
            
                default:
                System.out.println("Ingrese una opcion valida");
                    return true;
            
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        
    }

    private Patient readInfoFromPatient() throws Exception {
        System.out.println("Ingrese la informacion del paciente\n");
        System.out.println("Ingrese el nombre del paciente");
        String patientName = reader.nextLine();
        System.out.println("Ingrese el documento del paciente");
        String document = reader.nextLine();
        System.out.println("Ingrese la edad del paciente");
        String age = reader.nextLine();
        System.out.println("Ingrese el genero del paciente");
        String gender = reader.nextLine();
        System.out.println("Ingrese la direccion del paciente");
        String address = reader.nextLine();
        System.out.println("Ingrese el numero de telefono del paciente");
        String phoneNumber = reader.nextLine();
        System.out.println("Ingrese el email del paciente");
        String email = reader.nextLine();
        
        return patientBuilder.build(document, patientName, age, gender, address, phoneNumber, email);
    }

    private MedicalAppointment readInfoFromMedicalAppointment() throws Exception {
        System.out.println("Ingrese el nombre del paciente");
        String patientName = reader.nextLine();
        System.out.println("Ingrese el documento del paciente");
        String document = reader.nextLine();
        System.out.println("Ingrese el numero de telefono del paciente");
        String phoneNumber = reader.nextLine();
        System.out.println("Ingrese el email del paciente");
        String email = reader.nextLine();
        System.out.println("Ingrese la fecha de la cita");
        String date = reader.nextLine();
        System.out.println("Ingrese la hora de la cita");
        String time = reader.nextLine();
        System.out.println("Ingrese el motivo de la cita");
        String reason = reader.nextLine();
        
        return medicalAppointmentBuilder.build(date, time, reason, patientName, document, phoneNumber, email);
    }

    private Invoice readInvoiceData() throws Exception {
        System.out.println("Ingrese el documento del paciente");
        String document = reader.nextLine();
        System.out.println("Ingrese el nombre del paciente");
        String patientName = reader.nextLine();
        System.out.println("Ingrese el nombre del doctor");
        String name = reader.nextLine();
        System.out.println("Ingrese la compania de seguros");
        String insuranceCompany = reader.nextLine();
        System.out.println("Ingrese el numero de poliza");
        String policyNumber = reader.nextLine();
        System.out.println("Ingrese la vigencia de la poliza"); 
        String policyValidity = reader.nextLine();
        System.out.println("Ingrese la fecha de vencimiento de la poliza");
        String policyEndingDate = reader.nextLine();
        System.out.println("Ingrese si el paciente requiere medicamentos (Si/No)");
        String medicine = reader.nextLine();
        System.out.println("Ingrese el nombre del producto");
        String productName = reader.nextLine();
        System.out.println("Ingrese la orden clinica");
        String order = reader.nextLine();

        return invoiceBuilder.build(document, patientName, name, insuranceCompany, policyNumber, policyValidity, policyEndingDate, medicine, productName, order);
    }
    
}
