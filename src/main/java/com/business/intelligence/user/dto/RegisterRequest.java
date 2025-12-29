package com.business.intelligence.user.dto;

import com.business.intelligence.user.constant.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    public String username;
    public String password;
    public String fullName;
    public String email;
    public Role role;
}
