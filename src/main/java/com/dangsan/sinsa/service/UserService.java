package com.dangsan.sinsa.service;

import com.dangsan.sinsa.dto.SignUpDto;
import com.dangsan.sinsa.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    public User signUp(SignUpDto signUpDto) {
        User user = new User();

        return user;
    }
}
