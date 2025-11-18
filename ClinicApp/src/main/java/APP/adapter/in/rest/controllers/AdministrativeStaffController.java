package APP.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import APP.adapter.rest.mapper.InvoiceRestMapper;
import APP.adapter.rest.mapper.MedicalAppointmentRestMapper;
import APP.adapter.rest.mapper.PatientRestMapper;
import APP.adapter.rest.request.InvoiceRequest;
import APP.adapter.rest.request.MedicalAppointmentRequest;
import APP.adapter.rest.request.PatientRequest;
import APP.adapter.rest.response.InvoiceResponse;
import APP.adapter.rest.response.MedicalAppointmentResponse;
import APP.adapter.rest.response.PatientResponse;
import APP.application.usecase.AdministrativeStaffUseCase;
import APP.domain.model.Invoice;
import APP.domain.model.MedicalAppointment;
import APP.domain.model.Patient;

@RestController
@RequestMapping("/api/administrative_staff")
@PreAuthorize("hasRole('ADMINISTRATIVESTAFF')")
public class AdministrativeStaffController {

    @Autowired
    private AdministrativeStaffUseCase administrativeStaffUseCase;

    @Autowired
    private PatientRestMapper patientRestMapper;

    @Autowired
    private InvoiceRestMapper invoiceRestMapper;

    @Autowired
    private MedicalAppointmentRestMapper medicalAppointmentRestMapper;

    @PostMapping("/patient")
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientRequest request) throws Exception {
        Patient patient = patientRestMapper.toDomain(request);
        administrativeStaffUseCase.createPatient(patient);
        return new ResponseEntity<>(patientRestMapper.toResponse(patient), HttpStatus.CREATED);
    }

    @PostMapping("/invoice")
    public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody InvoiceRequest request) throws Exception {
        Invoice invoice = invoiceRestMapper.toDomain(request);
        administrativeStaffUseCase.createInvoice(invoice);
        return new ResponseEntity<>(invoiceRestMapper.toResponse(invoice), HttpStatus.CREATED);
    }

    @PostMapping("/medicalappointment")
    public ResponseEntity<MedicalAppointmentResponse> createMedicalAppointment(@RequestBody MedicalAppointmentRequest request) throws Exception {
        MedicalAppointment medicalAppointment = medicalAppointmentRestMapper.toDomain(request);
        administrativeStaffUseCase.createMedicalAppointment(medicalAppointment);
        return new ResponseEntity<>(medicalAppointmentRestMapper.toResponse(medicalAppointment), HttpStatus.CREATED);
    }

}
