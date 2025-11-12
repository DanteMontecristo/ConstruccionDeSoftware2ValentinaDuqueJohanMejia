**Manejo de Entities y JPA en ClinicApp**

En esta sección explicamos cómo están modeladas las entidades JPA y las reglas prácticas para trabajar con ellas.

Ubicación de las entidades:
- `src/main/java/APP/infrastructure/persistence/entities`

Puntos clave sobre JPA en el proyecto:
- Cada entidad está anotada con `@Entity` y `@Table(name = "...")`.
- El identificador de la entidad normalmente es un `Long id` con `@Id` y `@GeneratedValue(strategy = GenerationType.IDENTITY)`.
- Para relaciones se usa `@ManyToOne` y `@JoinColumn(name = "...")` cuando una entidad referencia a otra (p. ej. `ClinicalRecordEntity` tiene `clinicalOrder` y `patient`).
- En las entidades los tipos numéricos a veces son `Long`/`Integer` (wrappers) para permitir `null` antes de persistir; en el dominio se usan primitivos para simplificar el uso.

Buenas prácticas y reglas del proyecto:
1. Nunca exponer entidades JPA directamente en la API REST. Usa DTOs (`adapter.rest.response`) y mappers.
2. Mantén los nombres de campo de entidad claros: por ejemplo `patient` en vez de `name` cuando el campo referencia a `PatientEntity`.
3. Repositorios Spring Data (`infrastructure.persistence.repository`) usan métodos derivables por nombre: por ejemplo `findByPatient(PatientEntity patient)` funcionará si la entidad tiene `patient` como campo.
4. Cuando mapees domain → entity y entity → domain usa los mappers del paquete `infrastructure.persistence.mapper`.

Ejemplo de relación (sencillo):

ClinicalRecordEntity (simplificado):

- `@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "patient_id") private PatientEntity patient;`
- `@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "doctor_id") private UserEntity doctorName;`
- `@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "clinical_order_id") private ClinicalOrderEntity clinicalOrder;`

Si necesitas añadir un nuevo campo a la entidad:
1. Modifica la clase `Entity` agregando el campo con su `@Column` (o `@ManyToOne` si es relación).
2. Crea/actualiza el mapper para mapear el nuevo campo entre `Entity` y `Domain`.
3. Si la base de datos ya existe, crea una migración (Flyway/Liquibase) o actualiza el esquema manualmente.

Consejos para estudiantes:
- Usa los mappers existentes (ej. `ClinicalRecordMapper`) para ver cómo convertir tipos y manejar `null`.
- Evita mapear colecciones grandes directamente en `Entity` si no las necesitas; usa consultas específicas en el repositorio.
- Respeta `fetch = FetchType.LAZY` para evitar traer datos innecesarios en consultas.
