package APP.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.domain.model.Invoice;
import APP.domain.model.MedicalAppointment;
import APP.domain.model.Patient;
import APP.domain.services.CreateInvoice;
import APP.domain.services.CreateMedicalAppointmen;
import APP.domain.services.CreatePatient;
import APP.domain.services.UpdatePatient;

@Component
public class AdministrativeStaffUseCase {

    @Autowired
    private CreatePatient createPatient;
    
    @Autowired
    private CreateMedicalAppointmen createMedicalAppointmen;
    
    @Autowired
    private CreateInvoice createInvoice;
    
    @Autowired
    private UpdatePatient updatePatient;

    public void createPatient(Patient patient) throws Exception {
        createPatient.createPatient(patient);
    }

    public void createMedicalAppointment(MedicalAppointment medicalAppointment) throws Exception {
        createMedicalAppointmen.createMedicalAppointment(medicalAppointment);
    }

    public void createInvoice(Invoice invoice) throws Exception {
        createInvoice.createInvoice(invoice);
    }

    public void update(Patient patient) throws Exception {
        updatePatient.update(patient);
    }
    
}
