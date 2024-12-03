package com.application.task_springboot.dto;

import com.application.task_springboot.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;

    private Long userId;

    private UserRole userRole;
}
