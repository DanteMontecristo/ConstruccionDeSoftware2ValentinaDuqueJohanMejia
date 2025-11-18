package APP.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.adapter.in.builder.VisitBuilder;
import APP.adapter.rest.request.VisitRequest;
import APP.domain.model.Visit;

@Component
public class VisitRestMapper {

    @Autowired
    private VisitBuilder visitBuilder;

    public Visit toDomain(VisitRequest req) throws Exception {
        return visitBuilder.build(
            req.getDocument(),
            req.getVisitName(),
            req.getUserName()
        );
    }
}
