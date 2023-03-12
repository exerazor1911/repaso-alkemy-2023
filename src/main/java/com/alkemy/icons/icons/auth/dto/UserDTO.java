package com.alkemy.icons.icons.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    @Email(message = "Username must be a valid e-mail address")
    private String username;

    @Size(min = 8)
    private String password;
}
