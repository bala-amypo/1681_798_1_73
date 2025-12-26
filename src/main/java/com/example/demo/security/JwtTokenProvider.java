package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class JwtTokenProvider {

    public String generateToken(Long id, String email, List<String> roles) {
        return id + "-" + email + "-" + String.join(",", roles);
    }
}
