package com.application.task_springboot.services.auth;


import com.application.task_springboot.dto.SignUpRequest;
import com.application.task_springboot.dto.UserDto;

public interface AuthService {

    UserDto signupUser(SignUpRequest signUpRequest);

    boolean hasUserWithEmail(String email);

}
