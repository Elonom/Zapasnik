package com.example.Zapasnik.registration.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ZapUser {

    @Id
    public String login;

    public String password;

    public ZapUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public ZapUser(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
