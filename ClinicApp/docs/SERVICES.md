**Servicios y casos de uso**

En el proyecto hay dos conceptos relacionados: servicios de dominio (`domain.services`) y use cases de aplicación (`application.usecase`).

- Servicios de dominio (`APP.domain.services`):
  - Aquí está la lógica de negocio real. Ejemplos: `CreateClinicalRecord`, `CreateClinicalOrder`, `AuthenticationService`.
  - Estas clases conocen los `ports` (interfaces) que permiten persistir o consultar datos.

- Use Cases / Application (`APP.application.usecase`):
  - Adaptan los servicios de dominio para exponerse a través de controladores. Son la "fachada" de la lógica de negocio.
  - Ejemplo: `DoctorUseCase` contiene métodos como `createClinicalRecord`, `searchClinicalRecord` y llama internamente a `domain.services`.

Patrón de interacción (simplificado):
1. Controlador REST -> 2. Mapper/Builder -> 3. Use Case -> 4. Domain Service -> 5. Repository (JPA) -> Base de datos

Ejemplo concreto (crear registro clínico):
- Controlador `DoctorController.createClinicalRecord()` recibe `ClinicalRecordRequest`.
- `ClinicalRecordRestMapper.toDomain()` usa `ClinicalRecordBuilder` y validadores para crear `ClinicalRecord`.
- `DoctorUseCase.createClinicalRecord(clinicalRecord)` llama `CreateClinicalRecord.create(clinicalRecord)`.
- `CreateClinicalRecord` valida reglas de negocio (p. ej. que el paciente exista) y usa un `ClinicalRecordPort` para persistir la entidad.

Recomendaciones para entender y modificar servicios:
- Lee primero el `UseCase`: muestra qué operaciones esperará el controlador.
- Luego abre el `domain.service` correspondiente para ver reglas de negocio.
- Las pruebas unitarias se deben escribir a nivel de servicio y también para los builders/validators.

Errores comunes que un estudiante debe evitar:
- No llamar repositorios desde controladores (rompe la separación de responsabilidades).
- No mezclar entidades JPA con DTOs de entrada/salida.
- No confiar en que la validación ya está hecha: revisa los builders/validators antes de persistir.
