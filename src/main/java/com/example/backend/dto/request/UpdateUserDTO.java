package com.example.backend.dto.request;

import com.example.backend.enums.RoleName;
import lombok.Data;


@Data
public class UpdateUserDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private RoleName role;

}
