package com.project.uber.uberApp.controllers;

import com.project.uber.uberApp.dto.SignupDto;
import com.project.uber.uberApp.dto.UserDto;
import com.project.uber.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    UserDto signup(@RequestBody SignupDto signupDto) {
        return authService.signup(signupDto);
    }
}
