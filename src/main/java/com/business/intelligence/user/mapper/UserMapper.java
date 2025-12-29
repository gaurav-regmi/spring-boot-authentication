package com.business.intelligence.user.mapper;

import com.business.intelligence.user.dto.LoginResponse;
import com.business.intelligence.user.dto.RegisterRequest;
import com.business.intelligence.user.dto.RoleDTO;
import com.business.intelligence.user.entity.UserEntity;

import java.util.Date;
import java.util.Set;

public class UserMapper {
    public static UserEntity mapToUser(RegisterRequest req, String encodedPassword) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(req.getUsername());
        userEntity.setPassword(encodedPassword);
        userEntity.setFullName(req.getFullName());
        userEntity.setEmail(req.getEmail());
        userEntity.setActive('Y');

        return userEntity;
    }

    public static LoginResponse mapToLoginResponse(String token, Date expiryTime, String username, String email,
                                                   Set<RoleDTO> roleDTOSet) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setExpiresIn(expiryTime);
        loginResponse.setUsername(username);
        loginResponse.setEmail(email);
        loginResponse.setRoles(roleDTOSet);

        return loginResponse;
    }
}
