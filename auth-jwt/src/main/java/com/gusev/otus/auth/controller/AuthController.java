package com.gusev.otus.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.gusev.otus.auth.model.AuthenticationRequest;
import com.gusev.otus.auth.model.AuthenticationResponse;
import com.gusev.otus.auth.util.JwtUtil;

/**
 * Auth rest controller
 *
 * @author A. Gusev
 * @since 01 июль 2020 г.
 */
@RestController
public class AuthController {

    private final JwtUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JwtUtil jwtTokenUtil, UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello1")
    public String firstPage1() {
        return "Hello World";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwtTokenUtil.generateToken(userDetails)));
    }

}
