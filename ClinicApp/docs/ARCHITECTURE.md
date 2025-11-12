**Arquitectura del proyecto ClinicApp**

Este proyecto usa una arquitectura en capas inspirada en el patrón "Hexagonal / Ports & Adapters" mezclado con las prácticas comunes de Spring Boot.

- Capa de Entrada (Adapters In):
  - Path: `src/main/java/APP/adapter/in/rest/controllers`
  - Aquí están los controladores REST que reciben peticiones HTTP (por ejemplo `AdministrativeStaffController`, `DoctorController`). Los controladores validan/transforman la entrada usando *mappers* y *builders* y llaman a los *use cases* (casos de uso) de la capa de aplicación.

- Capa de Aplicación (Use Cases):
  - Path: `src/main/java/APP/application/usecase`
  - Contiene las clases que representan casos de uso de la aplicación (por ejemplo `DoctorUseCase`, `NurseUseCase`, `RRHHUseCase`). Estas clases coordinan la ejecución (llaman a servicios de dominio y puertos de salida).

- Capa de Dominio:
  - Path: `src/main/java/APP/domain`
  - Contiene entidades del dominio (`domain.model`), interfaces (puertos) `domain.ports` y servicios de dominio en `domain.services`.
  - Los servicios contienen la lógica de negocio.

- Adaptadores de Salida (Persistence / Infrastructure):
  - Path: `src/main/java/APP/infrastructure/persistence`
  - Aquí están las entidades JPA (`infrastructure.persistence.entities`), repositorios Spring Data (`infrastructure.persistence.repository`) y los mappers para convertir entre entidad y dominio.

- Mappers, Builders y Validators:
  - `adapter.in.builder` contiene builders que crean objetos de dominio a partir de datos crudos (strings) y aplican validaciones usando `adapter.in.validators`.
  - `adapter.rest.mapper` contiene helpers que transforman entre DTOs REST (`adapter.rest.request`, `adapter.rest.response`) y objetos de dominio.

Flujo típico de una petición HTTP (ejemplo: crear paciente):
1. El cliente hace `POST /api/administrative-staff/patient` con un JSON.
2. El controlador recibe `PatientRequest` y llama a `PatientRestMapper.toDomain()`.
3. `PatientRestMapper` usa `PatientBuilder` que valida los campos y devuelve un `Patient` (dominio).
4. El controlador llama a `AdministrativeStaffUseCase.createPatient(patient)`.
5. El `UseCase` llama a un servicio de dominio que persiste el `Patient` a través de un `Port` (puerto) que tiene una implementación en `infrastructure.persistence`.
6. La respuesta se transforma y se devuelve al cliente.

Por qué esta estructura ayuda a un estudiante:
- Separación clara de responsabilidades: cada capa hace una cosa.
- Los mappers y builders facilitan pruebas unitarias (puedes probar validaciones por separado).
- Usar ports/adapters permite cambiar la persistencia sin cambiar la lógica de negocio.

Terminología simple:
- Dominio: objetos que representan conceptos reales (Paciente, Usuario, Orden Clínica).
- Use case: una acción que el sistema realiza (crear registro clínico, buscar por paciente).
- Adapter: el código que adapta la tecnología (HTTP, JPA) al dominio.
