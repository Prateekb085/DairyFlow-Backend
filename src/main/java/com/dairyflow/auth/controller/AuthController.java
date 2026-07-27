package com.dairyflow.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dairyflow.auth.dto.LoginRequest;
import com.dairyflow.auth.dto.LoginResponse;
import com.dairyflow.auth.dto.RegisterRequest;
import com.dairyflow.auth.service.AuthService;
import com.dairyflow.auth.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}