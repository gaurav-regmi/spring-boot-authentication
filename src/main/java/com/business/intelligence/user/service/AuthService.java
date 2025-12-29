package com.business.intelligence.user.service;

import com.business.intelligence.dto.ServerResponse;
import com.business.intelligence.user.dto.LoginRequest;
import com.business.intelligence.user.dto.RegisterRequest;

public interface AuthService {

    ServerResponse register(RegisterRequest req);

    ServerResponse login(LoginRequest req);
}
