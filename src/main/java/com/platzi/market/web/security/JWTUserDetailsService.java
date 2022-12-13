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
        logger.info("JWTUserDetial");
        return new User("santi","passwordHash", new ArrayList<>());
    }
}
