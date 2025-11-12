**Dominio del proyecto ClinicApp**

Objetivo: explicar los modelos principales y cómo entenderlos sin conocimientos avanzados.

Conceptos principales:

- Paciente (`Patient`)
  - Atributos: `document` (número único), `name`, `age`, `gender`, `address`, `phoneNumber`, `email`.
  - Rol: representa a la persona que recibe atención médica.

- Usuario (`User`)
  - Atributos: `id`, `name`, `document`, `age`, `role`, `userName`, `password`.
  - Rol: representa un actor del sistema (médico, enfermera, administrativo, RRHH, etc.).

- Orden clínica (`ClinicalOrder`)
  - Atributos: `id`, `document` (número de referencia), `name` (paciente), `doctorName` (usuario), `medicine`, `doce`, `date`.
  - Rol: recetas o instrucciones médicas emitidas por un doctor.

- Registro clínico (`ClinicalRecord`)
  - Atributos: `document`, `name` (paciente), `doctorName`, `motive`, `diagnosis`, `medicine`, `medicalProcedure`, `clinicalOrder` (referencia a orden), `symptoms`, `status`, `date`.
  - Rol: historial de consulta/episodio médico.

- Factura (`Invoice`), Cita (`MedicalAppointment`), Visita (`Visit`), Ítems médicos (`MedicalItem`) son otros modelos usados en el sistema con estructura similar.

Reglas importantes del dominio (resumidas):
- `document` suele ser el identificador natural de una persona; en la persistencia hay campos `unique` para este valor.
- Los roles se definen en `domain.model.enums.Role` y controlan permisos para endpoints.
- En el dominio algunos campos usan tipos primitivos (`long`, `int`) y en las entidades JPA se usan wrappers (`Long`, `Integer`) para permitir nulls en BD.

Cómo se representan en código:
- Clases bajo `src/main/java/APP/domain/model` son clases POJO con getters y setters.
- Los mappers (`infrastructure.persistence.mapper` y `adapter.rest.mapper`) convierten entre: `Entity <-> Domain <-> DTO`.

Consejo para estudiantes:
- No intentes usar directamente las entidades JPA en los controladores; usa siempre mappers para evitar mezclar capas.
- Empieza creando pruebas unitarias para builders/validators: así entenderás las reglas de cada campo.
