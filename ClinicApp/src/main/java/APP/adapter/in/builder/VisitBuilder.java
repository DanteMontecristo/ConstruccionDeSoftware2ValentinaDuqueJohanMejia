package APP.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.adapter.in.validators.VisitValidator;
import APP.domain.model.User;
import APP.domain.model.Visit;

@Component
public class VisitBuilder {

    @Autowired
    private VisitValidator visitValidator;

    public Visit build(String document, String visitName, String userName) throws Exception {
        Visit visit = new Visit();
        visit.setDocument(visitValidator.documentValidator(document));
        visit.setVisitName(visitValidator.visitNameValidator(visitName));
        
        // Si userName es proporcionado, crear User simple con solo el nombre
        if (userName != null && !userName.isBlank()) {
            User user = new User();
            user.setName(userName);
            visit.setName(user);
        }
        
        return visit;
    }
}
