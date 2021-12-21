package com.dangsan.sinsa.controller;

import com.dangsan.sinsa.dto.SignUpDto;
import com.dangsan.sinsa.entity.User;
import com.dangsan.sinsa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    // 회원가입 정보를 받아오는 메소드
    // SignUpDto에서 username, password, password, nickname 값을 받아옴
    private final UserService userService;
    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody @Valid SignUpDto signUpDto, Errors errors) {
        return ResponseEntity.ok(userService.signUp(signUpDto));
    }
}
