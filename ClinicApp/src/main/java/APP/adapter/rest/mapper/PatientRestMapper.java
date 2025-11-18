package APP.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.adapter.in.builder.PatientBuilder;
import APP.adapter.rest.request.PatientRequest;
import APP.adapter.rest.response.PatientResponse;
import APP.domain.model.Patient;

@Component
public class PatientRestMapper {
@Autowired
private PatientBuilder patientBuilder;

public Patient toDomain(PatientRequest req) throws Exception {
    return patientBuilder.build(
        req.getDocument(),
        req.getName(),
        req.getAge(),
        req.getGender(),
        req.getAddress(),
        req.getPhoneNumber(),
        req.getEmail()
    );
}

public Patient toDomainForSearch(PatientRequest req) throws Exception {
    return patientBuilder.buildForSearch(req.getDocument());
}

public PatientResponse toResponse(Patient patient) {
    PatientResponse res = new PatientResponse();
    res.setDocument(patient.getDocument());
    res.setName(patient.getName());
    res.setAge(patient.getAge());
    res.setGender(patient.getGender());
    res.setAddress(patient.getAddress());
    res.setPhoneNumber(patient.getPhoneNumber());
    res.setEmail(patient.getEmail());
    return res;



}
}