package com.dangsan.sinsa.dto;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;



@RunWith(SpringRunner.class)
@SpringBootTest
class loginDtoTest {
    @Autowired
    private static ValidatorFactory factory;
    @Autowired
    private static Validator validator;
    @BeforeAll
    public static void init() {
        factory= Validation.buildDefaultValidatorFactory();
        validator=factory.getValidator();
    }
    @AfterAll
    public static void close() {
        factory.close();
    }
    @Test
    public void checkLoginDto(){
        //given
        LoginDto ld = new LoginDto();
        ld.setUsername("test1");
        ld.setPassword("ddddddd");
        //when
        Set<ConstraintViolation<LoginDto>> violations= validator.validate(ld);
        //then
        Assertions.assertThat(violations).isNotEmpty();
    }

}