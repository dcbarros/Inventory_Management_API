package com.stock_manager.stock_manager.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;

import com.stock_manager.stock_manager.dto.request.LoginDtoRequest;
import com.stock_manager.stock_manager.dto.response.LoginDetailsResponse;
import com.stock_manager.stock_manager.model.Token;
import com.stock_manager.stock_manager.repository.TokenRepository;
import com.stock_manager.stock_manager.security.service.TokenService;
import com.stock_manager.stock_manager.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthImpl implements AuthService{

    private final AuthenticationManager authenticationManager;
    private final SecurityContextLogoutHandler logoutHandler;
    private final TokenService tokenService;
    private final TokenRepository tokenRepository;

    @Override
    public LoginDetailsResponse login(LoginDtoRequest request) {
        log.info("Tentativa de login para o usuário: {}", request.email());
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generatedToken((UserDetails) auth.getPrincipal());
        log.info("Login bem-sucedido para o usuário: {}", request.email());
        return new LoginDetailsResponse(token);

    }

    @Override
    public void logout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")) {
            return;
        }
        final String token = header.substring(7);
        String username = tokenService.extractUsername(token);
        var expiration = tokenService.extractExpiration(token).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        String key = username + "-" + expiration;
        Token tokenBlackListed = Token.builder()
                .key(key)
                .expires(Duration.between(LocalDateTime.now(), expiration).getSeconds())
                .build();
        tokenRepository.save(tokenBlackListed);
        logoutHandler.logout(request, response, authentication);
    }
    
}
