package com.alkemy.icons.icons.auth.controller;

import com.alkemy.icons.icons.auth.dto.AuthenticationRequest;
import com.alkemy.icons.icons.auth.dto.AuthenticationResponse;
import com.alkemy.icons.icons.auth.dto.UserDTO;
import com.alkemy.icons.icons.auth.service.SignInService;
import com.alkemy.icons.icons.auth.service.UserDetailsCustomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;

    @Autowired
    private SignInService signInService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUp(@Valid @RequestBody UserDTO user) throws Exception {
        userDetailsCustomService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn (@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        return signInService.signIn(authenticationRequest);
    }
}
