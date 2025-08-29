package APP.domain.model;

import APP.domain.model.enums.Role;

public class Person {
    private String name;
    private long document;
    private String email;
    private String phoneNumber;
    private int age;
    private String address;
    private Role role;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getDocument() {
        return document;
    }
    public void setDocument(long document) {
        this.document = document;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

}
