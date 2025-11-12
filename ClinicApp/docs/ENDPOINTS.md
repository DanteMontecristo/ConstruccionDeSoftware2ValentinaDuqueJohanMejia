**Endpoints del proyecto ClinicApp**

En esta guía listamos los endpoints más importantes, el rol que puede usarlos y un ejemplo de request y response en JSON. Ajusta los cuerpos JSON según los campos de los DTOs en `src/main/java/APP/adapter/rest/request` y `.../response`.

1) Autenticación
- Endpoint: `POST /api/auth/login`
- Rol: público (no requiere token para obtener token)
- Request: `AuthRequest` (ejemplo)

```json
{
  "userName": "doc1",
  "password": "secreto"
}
```

- Response: `200 OK`, `TokenResponseDto` (ejemplo)

```json
{
  "token": "ey...",
  "expiresIn": 3600
}
```

2) Administrativo (crear paciente, factura, cita)
- Base: `POST /api/administrative-staff/*`
- Rol: `ADMINISTRATIVE_STAFF` (controlado por `@PreAuthorize` a nivel de clase)

Ejemplo: Crear paciente
- Endpoint: `POST /api/administrative-staff/patient`
- Request: `PatientRequest`

```json
{
  "document": "12345678",
  "name": "María Pérez",
  "age": "30",
  "gender": "F",
  "address": "Calle 1",
  "phoneNumber": "3001234567",
  "email": "maria@example.com"
}
```
- Response: `201 Created` con `PatientResponse` (ejemplo)

```json
{
  "document": 12345678,
  "name": "María Pérez",
  "age": 30,
  "gender": "F",
  "address": "Calle 1",
  "phoneNumber": "3001234567",
  "email": "maria@example.com"
}
```

3) Doctor
- Base: `POST /api/doctor/*`, `PUT /api/doctor/*`
- Rol: `DOCTOR`

Ejemplo: Crear registro clínico
- Endpoint: `POST /api/doctor/clinical-record`
- Request: `ClinicalRecordRequest` (ejemplo mínimo)

```json
{
  "doctorDocument": "987654",
  "patientDocument": "12345678",
  "orderId": "42",
  "motive": "Dolor de cabeza",
  "diagnosis": "Migraña",
  "medicine": "Paracetamol",
  "medicalProcedure": "Observación",
  "procedureDetail": "N/A",
  "vaccinationRecord": "al día",
  "allergies": "ninguna",
  "symptoms": "dolor intenso",
  "doce": "texto adicional"
}
```
- Response: `201 Created` con `ClinicalRecordResponse` (depende del mapper existente)

4) Enfermería (Nurse)
- Base: `POST /api/nurse/*`
- Rol: `NURSE`

Ejemplo: Buscar órdenes del paciente
- Endpoint: `POST /api/nurse/clinical-order/search`
- Request: `PatientRequest` (usa `document`)

```json
{ "document": "12345678", "name":"María Pérez" }
```
- Response: `200 OK` con lista de `ClinicalOrderResponse` (cada orden tiene `id`, `medicine`, `date`, `patientDocument`, `doctorDocument`)

5) RRHH (crear usuarios)
- Base: `POST /api/rrhh/*`
- Rol: `RRHH`

Ejemplo: Crear usuario (RRHH)
- Endpoint: `POST /api/rrhh/rrhh`
- Request: `CreateUserRequest`

```json
{
  "name":"Juan RRHH",
  "document":"55544433",
  "age":"40",
  "userName":"juan.rrhh",
  "password":"pass123",
  "role":"RRHH",
  "phoneNumber":"3000000000",
  "email":"juan@example.com",
  "address":"Oficina 1"
}
```
- Response: `201 Created` (sin body o con `UserResponse` si se modifica el controlador)

Reglas del proyecto sobre endpoints y validaciones
- Todos los endpoints consumen DTOs en `adapter.rest.request` y devuelven DTOs en `adapter.rest.response`.
- La validación se realiza en los *builders* (`adapter.in.builder`) usando `adapter.in.validators`. No se confía en datos sin validar.
- Los controladores no deben acceder a repositorios directamente: usan `UseCase`.
- Los roles controlan acceso con `@PreAuthorize("hasRole('ROLE_NAME')")` en los controladores o métodos.

Cómo probar localmente
1. Inicia la aplicación:

```powershell
.\mvnw.cmd -DskipTests spring-boot:run
```

2. Verás en consola la lista de endpoints y roles gracias a `APP.config.EndpointsRolesPrinter`.
3. Usa `curl` o Postman para llamar endpoints y enviar JSON. Ejemplo con `curl`:

```bash
curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"userName":"doc1","password":"secreto"}'
```

Si quieres, puedo generar colecciones Postman o ejemplos curl para todos los endpoints listados.
