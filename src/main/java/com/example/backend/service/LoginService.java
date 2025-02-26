package com.example.backend.service;

import com.example.backend.dto.LoginDTO;
import com.example.backend.model.User;

import java.util.List;
import java.util.Optional;

public interface LoginService {
    boolean checkLogin(LoginDTO request);

}