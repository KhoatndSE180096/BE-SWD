package com.example.backend.service.impl;

import com.example.backend.dto.request.LoginDTO;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean checkLogin(LoginDTO request) {
        boolean user = userRepository.existsByUsername(request.getUsername());
        if (!user) {
            return false;
        }
        return true;
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                return null;
            }
            return user;
        } catch (Exception e) {
            return null;
        }
    }


}