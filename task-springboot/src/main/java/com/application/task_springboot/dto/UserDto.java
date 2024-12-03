package com.application.task_springboot.dto;

import com.application.task_springboot.enums.UserRole;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;


@Data
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private UserRole userRole;
}
