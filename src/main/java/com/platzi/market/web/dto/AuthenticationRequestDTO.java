package com.platzi.market.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationRequestDTO {
    private String user;
    private String password;
}
