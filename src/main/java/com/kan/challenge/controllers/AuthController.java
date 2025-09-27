package com.kan.challenge.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    public static final Set<String> VALID_TOKENS = ConcurrentHashMap.newKeySet();

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        String token = UUID.randomUUID().toString();
        VALID_TOKENS.add(token);
        return ResponseEntity.ok("Bearer " + token);
    }
}
