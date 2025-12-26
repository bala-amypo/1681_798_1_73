package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class JwtTokenProvider {

    public String generateToken(Long id, String email, List<String> roles) {
        return id + "-" + email + "-" + String.join(",", roles);
    }

    public Long getUserIdFromToken(String token) {
        try { return Long.parseLong(token.split("-")[0]); }
        catch(Exception e) { return null; }
    }

    public boolean validateToken(String token) { return token != null && token.contains("-"); }
}
