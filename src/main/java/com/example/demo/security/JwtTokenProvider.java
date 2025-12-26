package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    public String generateToken(User user) {
        Long id = user.getId();
        String email = user.getEmail();
        List<String> roles = user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toList());
        return id + "-" + email + "-" + String.join(",", roles);
    }

    public Long getUserIdFromToken(String token) {
        try {
            return Long.parseLong(token.split("-")[0]);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("-");
    }
}
