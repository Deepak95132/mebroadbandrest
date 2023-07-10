package com.springboot.blog.service;

import com.springboot.blog.payload.AuthResponse;
import com.springboot.blog.payload.LoginDto;
import com.springboot.blog.payload.RegisterDto;

public interface AuthService {
    AuthResponse login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
