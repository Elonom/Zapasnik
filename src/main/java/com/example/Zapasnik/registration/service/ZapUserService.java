package com.example.Zapasnik.registration.service;

import com.example.Zapasnik.registration.repository.ZapUser;
import com.example.Zapasnik.registration.repository.ZapUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ZapUserService {


    private final PasswordEncoder passwordEncoder;
    private final ZapUserRepository zapUserRepository;

    @Autowired
    public ZapUserService(ZapUserRepository zapUserRepository, PasswordEncoder passwordEncoder) {
        this.zapUserRepository = zapUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ZapUser getZapUserByLogin(String login){
        return zapUserRepository.findById(login)
                .orElseThrow(()->{throw new UserNotFoundException(String.format("User with login: %s cannot be found", login));
                });
    }

    public ZapUserDto addUser(ZapUser zapUser){
        zapUserRepository.findById(zapUser.getLogin()).ifPresent((user)->{
            throw new UserAlreadyExistException(String.format("User %s already exists", zapUser.getLogin()));
        });
        ZapUser addedUser = zapUserRepository.findById(zapUser.getLogin())
                .orElseGet(()->{
                    zapUser.setPassword(passwordEncoder.encode(zapUser.getPassword()));
                    return zapUserRepository.save(zapUser);
                });
        return new ZapUserDto(addedUser.getLogin());
    }
}
