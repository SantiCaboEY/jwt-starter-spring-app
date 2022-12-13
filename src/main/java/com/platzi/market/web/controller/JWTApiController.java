package com.platzi.market.web.controller;

import com.platzi.market.web.dto.AuthenticationRequestDTO;
import com.platzi.market.web.dto.AuthenticationResponseDTO;
import com.platzi.market.web.dto.UserProfileDTO;
import com.platzi.market.web.security.JWTUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;

@RestController
@CrossOrigin
public class JWTApiController {
    private final static Logger logger = LoggerFactory.getLogger(JWTApiController.class);

    @Autowired
    private JWTUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/user")
    public ResponseEntity<UserProfileDTO> getUserProfile(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        logger.info("return default user");
        return ResponseEntity.ok(buildExampleUser());
    }

    private UserProfileDTO buildExampleUser() {
        return UserProfileDTO.builder()
                .bio("An average person")
                .birthDay(Date.from(Instant.now()))
                .name("Santiago")
                .lastName("Cabo")
                .verified(true)
                .build();
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticateDummyToken(
            @RequestBody AuthenticationRequestDTO request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUser(), request.getPassword())
            );
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new AuthenticationResponseDTO("Error Authenticating"));
        }
        String jwtToken = "dummyToken";
        return ResponseEntity.ok(new AuthenticationResponseDTO(jwtToken));
    }

}
