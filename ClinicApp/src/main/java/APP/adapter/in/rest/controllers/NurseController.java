package APP.adapter.in.rest.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import APP.adapter.rest.mapper.ClinicalOrderRestMapper;
import APP.adapter.rest.mapper.PatientRestMapper;
import APP.adapter.rest.request.PatientRequest;
import APP.adapter.rest.response.ClinicalOrderResponse;
import APP.application.usecase.NurseUseCase;
import APP.domain.model.Patient;

@RestController
@RequestMapping("/api/nurse")
@PreAuthorize("hasRole('NURSE')")
public class NurseController {

    @Autowired
    private NurseUseCase nurseUseCase;

    @Autowired
    private ClinicalOrderRestMapper clinicalOrderRestMapper;

    @Autowired
    private PatientRestMapper patientRestMapper;

    @PostMapping("/clinical-order/search")
    public ResponseEntity<List<ClinicalOrderResponse>> searchClinicalOrders(@RequestBody PatientRequest request) throws Exception {
        Patient patient = patientRestMapper.toDomainForSearch(request);
        List<APP.domain.model.ClinicalOrder> orders = nurseUseCase.searchClinicalOrder(patient);
        List<ClinicalOrderResponse> res = orders.stream().map(o -> clinicalOrderRestMapper.toResponse(o)).collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }

    @PostMapping("/patient/search")
    public ResponseEntity<APP.adapter.rest.response.PatientResponse> searchPatient(@RequestBody PatientRequest request) throws Exception {
        Patient patient = patientRestMapper.toDomainForSearch(request);
        Patient found = nurseUseCase.searchPatient(patient);
        return ResponseEntity.ok(patientRestMapper.toResponse(found));
    }

    @Autowired
    private APP.adapter.rest.mapper.VisitRestMapper visitRestMapper;

    @PostMapping("/visit")
    public ResponseEntity<Void> registerVisit(@RequestBody APP.adapter.rest.request.VisitRequest request) throws Exception {
        APP.domain.model.Visit visit = visitRestMapper.toDomain(request);
        nurseUseCase.registerVisit(visit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
 
