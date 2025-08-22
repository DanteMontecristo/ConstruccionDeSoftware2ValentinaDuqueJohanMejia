package APP.domain.model;

import APP.domain.model.enums.Role;

public class User {
    public String userName;
	public String password;
    private Role role;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
