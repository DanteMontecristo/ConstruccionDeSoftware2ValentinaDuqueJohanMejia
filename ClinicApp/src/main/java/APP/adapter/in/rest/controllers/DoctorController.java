package APP.adapter.in.rest.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import APP.adapter.rest.mapper.ClinicalOrderRestMapper;
import APP.adapter.rest.mapper.ClinicalRecordRestMapper;
import APP.adapter.rest.mapper.PatientRestMapper;
import APP.adapter.rest.request.ClinicalOrderRequest;
import APP.adapter.rest.request.ClinicalRecordRequest;
import APP.adapter.rest.request.PatientRequest;
import APP.adapter.rest.response.ClinicalOrderResponse;
import APP.adapter.rest.response.ClinicalRecordResponse;
import APP.application.usecase.DoctorUseCase;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;

@RestController
@RequestMapping("/api/doctor")
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorController {

    @Autowired
    private DoctorUseCase doctorUseCase;

    @Autowired
    private ClinicalRecordRestMapper clinicalRecordRestMapper;

    @Autowired
    private ClinicalOrderRestMapper clinicalOrderRestMapper;

    @Autowired
    private PatientRestMapper patientRestMapper;

    @PostMapping("/clinical-record/search")
    public ResponseEntity<List<ClinicalRecordResponse>> searchClinicalRecords(@RequestBody PatientRequest request) throws Exception {
        Patient patient = patientRestMapper.toDomain(request);
        List<ClinicalRecord> records = doctorUseCase.searchClinicalRecord(patient);
        List<ClinicalRecordResponse> res = records.stream().map(r -> clinicalRecordRestMapper.toResponse(r)).collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }

    @PostMapping("/clinical-record")
    public ResponseEntity<ClinicalRecordResponse> createClinicalRecord(@RequestBody ClinicalRecordRequest request) throws Exception {
        ClinicalRecord record = clinicalRecordRestMapper.toDomain(request);
        doctorUseCase.createClinicalRecord(record);
        return new ResponseEntity<>(clinicalRecordRestMapper.toResponse(record), HttpStatus.CREATED);
    }

    @PutMapping("/clinical-record")
    public ResponseEntity<Void> updateClinicalRecord(@RequestBody ClinicalRecordRequest request) throws Exception {
        ClinicalRecord record = clinicalRecordRestMapper.toDomain(request);
        doctorUseCase.updateClinicalRecord(record);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/clinical-order")
    public ResponseEntity<ClinicalOrderResponse> createClinicalOrder(@RequestBody ClinicalOrderRequest request) throws Exception {
        ClinicalOrder order = clinicalOrderRestMapper.toDomain(request);
        doctorUseCase.createClinicalOrder(order);
        return new ResponseEntity<>(clinicalOrderRestMapper.toResponse(order), HttpStatus.CREATED);
    }

}
 
