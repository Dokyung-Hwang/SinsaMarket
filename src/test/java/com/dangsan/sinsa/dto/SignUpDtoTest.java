package com.dangsan.sinsa.dto;

import com.dangsan.sinsa.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SignUpDtoTest {

    @Test
    public void test_1(){
        SignUpDto signUpDto= new SignUpDto();
        signUpDto.setPassword("DDD");

        System.out.println(signUpDto.getPassword());


    }
}