package com.business.intelligence.user.controller;

import com.business.intelligence.builder.ResponseBuilder;
import com.business.intelligence.dto.ServerResponse;
import com.business.intelligence.user.dto.LoginRequest;
import com.business.intelligence.user.dto.RegisterRequest;
import com.business.intelligence.user.service.AuthService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @NonNull RegisterRequest req) {
        ServerResponse response = authService.register(req);
        return ResponseBuilder.response(response);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @NonNull LoginRequest req) {
        ServerResponse response = authService.login(req);
        return ResponseBuilder.response(response);
    }
}
