package com.dairyflow.auth.dto;

import com.dairyflow.auth.entity.Role;

public class RegisterRequest {

    private String fullName;
    private String email;
    private String mobileNumber;
    private String password;
    private Role role;

    public RegisterRequest() {
    }

    public RegisterRequest(String fullName, String email, String mobileNumber, String password, Role role) {
        this.fullName = fullName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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