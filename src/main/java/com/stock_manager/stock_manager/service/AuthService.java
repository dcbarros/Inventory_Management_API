package com.stock_manager.stock_manager.service;

import com.stock_manager.stock_manager.dto.request.LoginDtoRequest;
import com.stock_manager.stock_manager.dto.response.LoginDetailsResponse;

import org.springframework.security.core.Authentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    LoginDetailsResponse login(LoginDtoRequest request);
    void logout(Authentication authentication, HttpServletRequest request , HttpServletResponse response);
}
