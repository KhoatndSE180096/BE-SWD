package com.example.backend.service;

import com.example.backend.dto.request.LoginDTO;
import com.example.backend.model.User;

public interface LoginService {
    boolean checkLogin(LoginDTO request);
    User getUserByUsername(String username);

}