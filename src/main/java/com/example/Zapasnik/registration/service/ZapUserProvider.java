package com.example.Zapasnik.registration.service;

import com.example.Zapasnik.registration.repository.ZapUser;
import com.example.Zapasnik.registration.repository.ZapUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ZapUserProvider implements UserDetailsService{

    private final ZapUserRepository zapUserRepository;

    @Autowired
    public ZapUserProvider(ZapUserRepository zapUserRepository) {
        this.zapUserRepository = zapUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UserNotFoundException {
        ZapUser zapUser = zapUserRepository.findById(userName).orElseThrow(()->{
            throw new UserNotFoundException(userName);
        });
        return new User(zapUser.getLogin(), zapUser.getPassword(), Collections.emptyList());
    }
}
