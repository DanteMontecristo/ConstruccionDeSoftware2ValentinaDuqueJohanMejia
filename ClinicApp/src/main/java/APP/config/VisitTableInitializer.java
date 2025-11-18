package APP.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class VisitTableInitializer implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        try {
            // Verificar y modificar la estructura de la tabla visits
            System.out.println("[VisitTableInitializer] Iniciando verificación de tabla visits...");
            
            // Borrar todos los registros para evitar conflictos
            try {
                String deleteAllSql = "DELETE FROM visits";
                int deleted = jdbcTemplate.update(deleteAllSql);
                System.out.println("[VisitTableInitializer] Se eliminaron " + deleted + " registros de visits");
            } catch (Exception e) {
                System.out.println("[VisitTableInitializer] Tabla visits no existe aún");
            }
            
            // Modificar la columna user_id para permitir NULL (si existe)
            try {
                String alterSql = "ALTER TABLE visits MODIFY COLUMN user_id BIGINT NULL";
                jdbcTemplate.execute(alterSql);
                System.out.println("[VisitTableInitializer] ✓ Columna user_id modificada a nullable");
            } catch (Exception e) {
                System.out.println("[VisitTableInitializer] La columna user_id ya es nullable o la tabla no existe");
            }
            
        } catch (Exception e) {
            System.out.println("[VisitTableInitializer] Error general: " + e.getMessage());
        }
    }
}

