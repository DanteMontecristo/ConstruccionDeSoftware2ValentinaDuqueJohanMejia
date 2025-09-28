package APP.application.port.in;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import APP.application.port.in.builder.ClinicalOrderBuilder;
import APP.application.port.in.builder.ClinicalRecordBuilder;
import APP.application.usecase.DoctorUseCase;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;

public class DoctorClient {

    private static final String MENU = "Ingrese una de las opciones" +
    "\n 1. Crear orden medica" +
    "\n 2. Crear historia clinica" +
    "\n 3. Actualizar historia clinica" +
    "\n 4. Buscar historia clinica" +
    "\n 5. Salir";

	private static Scanner reader = new Scanner(System.in);

    private DoctorUseCase doctorUseCase;

    @Autowired
    private ClinicalOrderBuilder clinicalOrderBuilder;

    @Autowired
    private ClinicalRecordBuilder clinicalRecordBuilder;

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
                    ClinicalOrder clinicalOrder = readClinicalOrderData();
                    doctorUseCase.createClinicalOrder(clinicalOrder);
                    return true;
                case "2":
                    ClinicalRecord clinicalRecord = readClinicalRecordData();
                    doctorUseCase.createClinicalRecord(clinicalRecord);
                    return true;
                case "3":
                    
                    return true;
                case "4":
                    
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

    private ClinicalOrder readClinicalOrderData() throws Exception {
        System.out.println("Ingrese la informacion de la orden medica\n");
        System.out.println("Ingrese el ID de la orden medica");
        String id = reader.nextLine();
        System.out.println("Ingrese el documento del paciente");
        String document = reader.nextLine();
        System.out.println("Ingrese el nombre del paciente");
        String patientName = reader.nextLine();
        System.out.println("Ingrese el nombre del doctor");
        String name = reader.nextLine();
        System.out.println("Ingrese la medicina recetada");
        String medicine = reader.nextLine();
        System.out.println("Ingrese la dosis de la medicina");
        String doce = reader.nextLine();

        return clinicalOrderBuilder.build(id, document, patientName, name, medicine, doce);
    }

    private ClinicalRecord readClinicalRecordData() throws Exception {
        System.out.println("Ingrese la informacion de la historia medica\n");
        System.out.println("ingrese la cedula del doctor que la genera");
		String document = reader.nextLine();
		System.out.println("ingrese el id del paciente");
		String patientId = reader.nextLine();
		System.out.println("ingrese el id de la orden");
		String orderId = reader.nextLine();
		System.out.println("ingrese el motivo de la consulta");
		String motive = reader.nextLine();
		System.out.println("ingrese el diagnostico");
		String diagnosis = reader.nextLine();
		System.out.println("la medicina asignada");
		String medicine = reader.nextLine();
		System.out.println("ingrese la dosis del medicamento");
		String doce = reader.nextLine();
		System.out.println("ingrese el nombre del procedimiento");
		String procedureName = reader.nextLine();
		System.out.println("ingrese las alergias");
		String allergies = reader.nextLine();
		System.out.println("ingrese sintomas");
		String symptoms = reader.nextLine();
		System.out.println("ingrese las vacunas");
		String vaccination = reader.nextLine();
        System.out.println("ingrese los detalles del procedimiento");
        String procedureDetail = reader.nextLine();
        System.out.println("ingrese el estado de la historia clinica");
        String status = reader.nextLine();

        return clinicalRecordBuilder.create(document, patientId, orderId);
    }

}
