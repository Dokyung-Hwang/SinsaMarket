package com.dangsan.sinsa.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
/*
EnableGlobalMethodSecurity은 메소드에서 @PreAuthorize, @PostAuthorize 사용해
인가 처리를 할 때 사용한다.
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

}
