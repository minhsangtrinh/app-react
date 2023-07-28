package com.example.reactapp.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(@RequestBody LoginDTO loginDTO){
        String token = authService.login(loginDTO);

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtResponse);
    }
}
