package APP.application.port.in;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import APP.application.usecase.RRHHUseCase;
import APP.domain.model.User;
import APP.application.port.in.builder.UserBuilder;

public class RRHHClient {

    private static final String MENU = "Ingrese una de las opciones" +
    "\n 1. Crear" +
    "\n 2. Actualizar" +
    "\n 3. Eliminar" +
    "\n 4. Salir";

	private static Scanner reader = new Scanner(System.in);

    @Autowired
    private RRHHUseCase rrhhUseCase;

    @Autowired
    private UserBuilder UserBuilder;

    public void session() {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    // Menú principal
    private boolean menu(){
        try {
            System.out.println(MENU);
            String option = reader.nextLine();
            switch (option) {
                case "1":
                    createSubMenu();
                    return true;
                
                case "2":
                    updateSubMenu();
                    return true;
                
                case "3":
                    deleteSubMenu();
                    return true;

                default:
                    System.out.println("Ingrese una opcion valida");
                    return true;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    // Submenú de creación
    private void createSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\nSUBMENÚ: CREAR, elije una opción");
            System.out.println("1. Crear RRHH");
            System.out.println("2. Crear Personal Administrativo");
            System.out.println("3. Crear Soporte de Información");
            System.out.println("4. Crear Enfermero");
            System.out.println("5. Crear Doctor");
            System.out.println("6. Volver al menú principal");
            String suboption = reader.nextLine().trim();

            try {
                switch (suboption) {
                
                case "1":{
                    User user = readInfoFromRRHH();
                    rrhhUseCase.createRrHh(user);
                    break;
                }

                case "2":{
                    User user = readInfoFromAdministrativeStaff();
                    rrhhUseCase.createAdministrativeStaff(user);
                    break;
                }

                case "3":{
                    User user = readInfoFromInformationSupport();
                    rrhhUseCase.createInformationSupport(user);
                    break;
                }
                
                case "4":{
                    User user = readInfoFromNurse();
                    rrhhUseCase.createNurse(user);
                    break;
                }

                case "5":{
                    User user = readInfoFromDoctor();
                    rrhhUseCase.createDoctor(user);
                    break;
                }

                case "6":
                    back = true;
                    System.out.println("Regresando al menú principal...");
                    break;

                default:
                    System.out.println("Opción no valida.");
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
            
        }
    }

    private User readInfoFromRRHH() throws Exception {
        System.out.println("Ingrese la informacion del empleado\n");
        System.out.println("Ingrese el nombre del empleado");
        String name = reader.nextLine();
        System.out.println("Ingrese el documento del empleado");
        String document = reader.nextLine();
        System.out.println("Ingrese el email del empleado");
        String email = reader.nextLine();
        System.out.println("Ingrese el numero de telefono del empleado");
        String phoneNumber = reader.nextLine();
        System.out.println("Ingrese la edad del empleado");
        String age = reader.nextLine();
        System.out.println("Ingrese la direccion del empleado");
        String address = reader.nextLine();
        System.out.println("ingrese el rol del empleado");
        String role = reader.nextLine();
        System.out.println("Ingrese el usuario del empleado");
        String userName = reader.nextLine();
        System.out.println("Ingrese la contrasena del empleado");
        String password = reader.nextLine();

        return UserBuilder.build(name, document, email, phoneNumber, age, address, role, userName, password);
    }

    private User readInfoFromAdministrativeStaff() throws Exception {
        System.out.println("Ingrese la informacion del empleado\n");
        System.out.println("Ingrese el nombre del empleado");
        String name = reader.nextLine();
        System.out.println("Ingrese el documento del empleado");
        String document = reader.nextLine();
        System.out.println("Ingrese el email del empleado");
        String email = reader.nextLine();
        System.out.println("Ingrese el numero de telefono del empleado");
        String phoneNumber = reader.nextLine();
        System.out.println("Ingrese la edad del empleado");
        String age = reader.nextLine();
        System.out.println("Ingrese la direccion del empleado");
        String address = reader.nextLine();
        System.out.println("ingrese el rol del empleado");
        String role = reader.nextLine();
        System.out.println("Ingrese el usuario del empleado");
        String userName = reader.nextLine();
        System.out.println("Ingrese la contrasena del empleado");
        String password = reader.nextLine();

        return UserBuilder.build(name, document, email, phoneNumber, age, address, role, userName, password);
    }

    private User readInfoFromInformationSupport() throws Exception {
        System.out.println("Ingrese la informacion del empleado\n");
        System.out.println("Ingrese el nombre del empleado");
        String name = reader.nextLine();
        System.out.println("Ingrese el documento del empleado");
        String document = reader.nextLine();
        System.out.println("Ingrese el email del empleado");
        String email = reader.nextLine();
        System.out.println("Ingrese el numero de telefono del empleado");
        String phoneNumber = reader.nextLine();
        System.out.println("Ingrese la edad del empleado");
        String age = reader.nextLine();
        System.out.println("Ingrese la direccion del empleado");
        String address = reader.nextLine();
        System.out.println("ingrese el rol del empleado");
        String role = reader.nextLine();
        System.out.println("Ingrese el usuario del empleado");
        String userName = reader.nextLine();
        System.out.println("Ingrese la contrasena del empleado");
        String password = reader.nextLine();

        return UserBuilder.build(name, document, email, phoneNumber, age, address, role, userName, password);
    }

    private User readInfoFromNurse() throws Exception {
        System.out.println("Ingrese la informacion del empleado\n");
        System.out.println("Ingrese el nombre del empleado");
        String name = reader.nextLine();
        System.out.println("Ingrese el documento del empleado");
        String document = reader.nextLine();
        System.out.println("Ingrese el email del empleado");
        String email = reader.nextLine();
        System.out.println("Ingrese el numero de telefono del empleado");
        String phoneNumber = reader.nextLine();
        System.out.println("Ingrese la edad del empleado");
        String age = reader.nextLine();
        System.out.println("Ingrese la direccion del empleado");
        String address = reader.nextLine();
        System.out.println("ingrese el rol del empleado");
        String role = reader.nextLine();
        System.out.println("Ingrese el usuario del empleado");
        String userName = reader.nextLine();
        System.out.println("Ingrese la contrasena del empleado");
        String password = reader.nextLine();

        return UserBuilder.build(name, document, email, phoneNumber, age, address, role, userName, password);
    }

    private User readInfoFromDoctor() throws Exception {
        System.out.println("Ingrese la informacion del empleado\n");
        System.out.println("Ingrese el nombre del empleado");
        String name = reader.nextLine();
        System.out.println("Ingrese el documento del empleado");
        String document = reader.nextLine();
        System.out.println("Ingrese el email del empleado");
        String email = reader.nextLine();
        System.out.println("Ingrese el numero de telefono del empleado");
        String phoneNumber = reader.nextLine();
        System.out.println("Ingrese la edad del empleado");
        String age = reader.nextLine();
        System.out.println("Ingrese la direccion del empleado");
        String address = reader.nextLine();
        System.out.println("ingrese el rol del empleado");
        String role = reader.nextLine();
        System.out.println("Ingrese el usuario del empleado");
        String userName = reader.nextLine();
        System.out.println("Ingrese la contrasena del empleado");
        String password = reader.nextLine();

        return UserBuilder.build(name, document, email, phoneNumber, age, address, role, userName, password);
    }

    // Submenú de actualización
    private void updateSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\nSUBMENÚ: ACTUALIZAR, elije una opción");
            System.out.println("1. Actualizar RRHH");
            System.out.println("2. Actualizar Personal Administrativo");
            System.out.println("3. Actualizar Soporte de Información");
            System.out.println("4. Actualizar Enfermero");
            System.out.println("5. Actualizar Doctor");
            System.out.println("6. Volver al menú principal");
            String suboption = reader.nextLine().trim();

            try {
                switch (suboption) {
                case "1":
                    
                    break;

                case "2":
                    
                    break;

                case "3":
                    
                    break;

                case "4":
                    
                    break;

                case "5":
                    
                    break;

                case "6":
                    back = true;
                    System.out.println("Regresando al menú principal...");
                    break;

                default:
                    System.out.println("Opción no valida.");
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    // Submenú de eliminación
    private void deleteSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\nSUBMENÚ: ELIMINAR, elije una opción");
            System.out.println("1. Eliminar RRHH");
            System.out.println("2. Eliminar Personal Administrativo");
            System.out.println("3. Eliminar Soporte de Información");
            System.out.println("4. Eliminar Enfermero");
            System.out.println("5. Eliminar Doctor");
            System.out.println("6. Volver al menú principal");
            String suboption = reader.nextLine().trim();
 
            try {
                switch (suboption) {
                case "1":
                    
                    break;

                case "2":
                    
                    break;

                case "3":
                    
                    break;

                case "4":
                    
                    break;

                case "5":
                    
                    break;

                case "6":
                    back = true;
                    System.out.println("Regresando al menú principal...");
                    break;

                default:
                    System.out.println("Opción no valida.");
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

}
