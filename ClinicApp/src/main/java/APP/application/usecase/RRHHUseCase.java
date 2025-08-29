package APP.application.usecase;

import APP.domain.services.CreateUser;
import APP.domain.model.User;
import APP.domain.model.enums.Role;

public class RRHHUseCase {

    private CreateUser createUser;

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
}
