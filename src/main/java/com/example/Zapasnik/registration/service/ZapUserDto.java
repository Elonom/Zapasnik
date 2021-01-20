package com.example.Zapasnik.registration.service;

public class ZapUserDto {

    public String userLogin;

    public ZapUserDto(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public ZapUserDto() {
    }
}
