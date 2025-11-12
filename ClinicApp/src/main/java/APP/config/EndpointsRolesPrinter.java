package APP.config;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Imprime por consola las rutas REST y la expresión de `@PreAuthorize`
 * asociada (si existe) al arrancar la aplicación.
 */
@Component
public class EndpointsRolesPrinter implements ApplicationRunner {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n=== Endpoints y roles detectados ===");

        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();

        handlerMethods.forEach((info, handler) -> {
            var cond = info.getPatternsCondition();
            Set<String> patterns = cond != null ? cond.getPatterns() : java.util.Collections.emptySet();

            Class<?> controllerClass = handler.getBeanType();
            PreAuthorize classAuth = controllerClass.getAnnotation(PreAuthorize.class);
            PreAuthorize methodAuth = handler.getMethodAnnotation(PreAuthorize.class);

            String authExpr = null;
            if (methodAuth != null) authExpr = methodAuth.value();
            else if (classAuth != null) authExpr = classAuth.value();

            String roleDisplay = authExpr != null ? authExpr : "[NO ROLE / PUBLIC]";

            patterns.forEach(p -> System.out.println(p + "  ->  " + roleDisplay));
        });

        System.out.println("=== Fin de la lista ===\n");
    }
}
