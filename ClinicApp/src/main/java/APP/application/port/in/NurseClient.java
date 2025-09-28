package APP.application.port.in;

import java.util.Scanner;

public class NurseClient {

    private static final String MENU = "Ingrese una de las opciones" +
    "\n 1. Buscar orden medica" +
    "\n 2. Buscar paciente" +
    "\n 3. Registrar visita" +
    "\n 4. Salir";
    
	private static Scanner reader = new Scanner(System.in);

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
                    
                    return true;

                case "2":
                    
                    return true;

                case "3":
                    
                    return true;

                case "4":
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
}
