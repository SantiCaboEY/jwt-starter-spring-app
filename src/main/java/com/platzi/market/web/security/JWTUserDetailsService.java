package com.platzi.market.web.security;

import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JWTUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(JWTUserDetailsService.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Esto emula la obtención de datos del usuario.
        //En un caso real lo traeríamos de una DB, por ej.
        //No guardamos el password directamente!
        //tiene que estar expresado como hash bcrypt
        return new User(
                "santi",
                "$2y$10$rskG.9SkhiIIz0OsMJe64uaqhoWZp/dz/JiH5NsFwYq2jS2T1ZsFe",
                new ArrayList<>());
    }
}
