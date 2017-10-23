package org.academiadecodigo.javabank.dto;

import org.academiadecodigo.javabank.model.Customer;

public class CustomerDTO {

    private Integer id;
    private Integer version;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, Integer version, String firstName, String lastName, String phone, String email) {
        this.id = id;
        this.version = version;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
