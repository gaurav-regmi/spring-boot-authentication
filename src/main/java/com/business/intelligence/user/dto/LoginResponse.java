package com.business.intelligence.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private Date expiresIn;
    private String username;
    private String email;
    private Set<RoleDTO> roles;
}
