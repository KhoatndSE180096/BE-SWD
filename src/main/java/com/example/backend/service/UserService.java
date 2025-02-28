package com.example.backend.service;

import com.example.backend.dto.request.CreateUserDTO;
import com.example.backend.dto.request.UpdateUserDTO;
import com.example.backend.model.User;
import java.util.List;

public interface UserService {
    User createUser(CreateUserDTO user);
    User updateUser(String userId, UpdateUserDTO request);

    User getUserById(String userID);
    List<User> getAllUsers();

    void deleteUser(String userID);
    User findByUsername(String username);
    User findByEmail(String email);
}