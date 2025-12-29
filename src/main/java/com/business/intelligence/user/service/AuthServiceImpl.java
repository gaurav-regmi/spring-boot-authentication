package com.business.intelligence.user.service;

import com.business.intelligence.builder.ResponseMsg;
import com.business.intelligence.constant.MsgConstant;
import com.business.intelligence.dto.ServerResponse;
import com.business.intelligence.exception.InvalidDataException;
import com.business.intelligence.security.util.JwtUtil;
import com.business.intelligence.user.dto.LoginRequest;
import com.business.intelligence.user.dto.LoginResponse;
import com.business.intelligence.user.dto.RegisterRequest;
import com.business.intelligence.user.dto.RoleDTO;
import com.business.intelligence.user.entity.RoleEntity;
import com.business.intelligence.user.entity.UserEntity;
import com.business.intelligence.user.mapper.UserMapper;
import com.business.intelligence.user.repository.RoleRepository;
import com.business.intelligence.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ServerResponse register(RegisterRequest req) {

        if (userRepository.findByUsername(req.username).isPresent()) {
            throw new InvalidDataException(MsgConstant.User.USER_ALREADY_EXISTS);
        }

        String encodedPassword = passwordEncoder.encode(req.password);
        UserEntity user = UserMapper.mapToUser(req, encodedPassword);

        String roleName = "USER";
        Optional<RoleEntity> role = roleRepository.findByName(roleName);
        if (role.isEmpty()) {
            throw new InvalidDataException(MsgConstant.Exception.USER_ROLE_NOT_FOUND);
        }
        Set<RoleEntity> userRoles = Set.of(role.get());
        user.setRoles(userRoles);

        userRepository.save(user);

        return ResponseMsg.success(MsgConstant.User.REGISTERED);
    }

    public ServerResponse login(LoginRequest req) {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(req.getUsername());

        if (optionalUser.isEmpty()) {
            throw new InvalidDataException(MsgConstant.User.INVALID_CREDENTIALS);
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));

        UserEntity user = optionalUser.get();

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new InvalidDataException(MsgConstant.User.INVALID_CREDENTIALS);
        }
        String token = jwtUtil.generateToken(req.getUsername());
        Date expiryTime = jwtUtil.generateExpiryTime();

        Set<RoleDTO> roleDTOSet = user.getRoles().stream()
                .map(RoleDTO::new)
                .collect(Collectors.toSet());

        LoginResponse res = UserMapper.mapToLoginResponse(token, expiryTime, user.getUsername(), user.getEmail(),
                roleDTOSet);

        return ResponseMsg.success(res, MsgConstant.Login.SUCCESS);
    }
}
