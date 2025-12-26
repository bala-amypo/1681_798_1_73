package com.example.demo.security;

import com.example.demo.service.impl.CustomUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT filter for authenticating requests.
 * Skips /auth/login and /auth/register endpoints.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider tokenProvider;

    public JwtAuthenticationFilter(CustomUserDetailsService userDetailsService,
                                   JwtTokenProvider tokenProvider) {
        this.userDetailsService = userDetailsService;
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getServletPath();

        // Skip login and register endpoints
        if (path.startsWith("/auth/login") || path.startsWith("/auth/register")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String header = request.getHeader("Authorization");
            String username = null;
            String token = null;

            if (header != null && header.startsWith("Bearer ")) {
                token = header.substring(7);
                if (tokenProvider.validateToken(token)) {
                    username = tokenProvider.getUsernameFromToken(token);
                }
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        } catch (Exception e) {
            // Log the exception but don’t block the request; security context will be empty
            logger.error("Cannot set user authentication: {}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
}
