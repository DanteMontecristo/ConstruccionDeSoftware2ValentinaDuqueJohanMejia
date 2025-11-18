package APP.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.adapter.in.validators.UserValidator;
import APP.domain.model.User;

@Component
public class UserBuilder {

	@Autowired
	private UserValidator userValidator;
    
	// Signature matches the order used by UserRestMapper: name, document, age, userName, password, address, role, email, phoneNumber
	public User build(String name, String document, String age, String userName, String password, String address, String role, String email, String phoneNumber) throws Exception {
		User user = new User();
		user.setName(userValidator.nameValidator(name));
		user.setDocument(userValidator.documentValidator(document));
		user.setAge(userValidator.ageValidator(age));
		user.setUserName(userValidator.userNameValidator(userName));
		user.setPassword(userValidator.passwordValidator(password));
		user.setRole(userValidator.roleValidator(role));
		user.setEmail(userValidator.emailValidator(email));
		user.setPhoneNumber(userValidator.phoneNumberValidator(phoneNumber));
		user.setAddress(userValidator.addressValidator(address));

		return user;
	}
    
}
