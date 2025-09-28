package APP.application.usecase;

import APP.domain.services.CreateUser;
import APP.domain.model.User;
import APP.domain.model.enums.Role;
import APP.domain.services.UpdateUser;
import APP.domain.services.EliminateUser;

public class RRHHUseCase {

    private CreateUser createUser;
    private UpdateUser updateUser;
    private EliminateUser eliminateUser;

    public void createRrHh(User user) throws Exception {
        user.setRole(Role.RRHH);
        createUser.create(user);
    }

    public void createAdministrativeStaff(User user) throws Exception {
        user.setRole(Role.ADMINISTRATIVESTAFF);
        createUser.create(user);
    }

    public void createInformationSupport(User user) throws Exception {
        user.setRole(Role.INFORMATIONSUPPORT);
        createUser.create(user);
    }

    public void createNurse(User user) throws Exception {
        user.setRole(Role.NURSE);
        createUser.create(user);
    }

    public void createDoctor(User user) throws Exception {
        user.setRole(Role.DOCTOR);
        createUser.create(user);
    }

    public void updateRrHh(User user) throws Exception {
        user.setRole(Role.RRHH);
        updateUser.update(user);
    }

    public void updateAdministrativeStaff(User user) throws Exception {
        user.setRole(Role.ADMINISTRATIVESTAFF);
        updateUser.update(user);
    }

    public void updateInformationSupport(User user) throws Exception {
        user.setRole(Role.INFORMATIONSUPPORT);
        updateUser.update(user);
    }

    public void updateNurse(User user) throws Exception {
        user.setRole(Role.NURSE);
        updateUser.update(user);
    }

    public void updateDoctor(User user) throws Exception {
        user.setRole(Role.DOCTOR);
        updateUser.update(user);
    }

    public void eliminateRrHh(User user) throws Exception {
        user.setRole(Role.RRHH);
        eliminateUser.eliminate(user);
    }
    
    public void eliminateAdministrativeStaff(User user) throws Exception {
        user.setRole(Role.ADMINISTRATIVESTAFF);
        eliminateUser.eliminate(user);
    }

    public void eliminateInformationSupport(User user) throws Exception {
        user.setRole(Role.INFORMATIONSUPPORT);
        eliminateUser.eliminate(user);
    }

    public void eliminateNurse(User user) throws Exception {
        user.setRole(Role.NURSE);
        eliminateUser.eliminate(user);
    }

    public void eliminateDoctor(User user) throws Exception {
        user.setRole(Role.DOCTOR);
        eliminateUser.eliminate(user);
    }
    
}
