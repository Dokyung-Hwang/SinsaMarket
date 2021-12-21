package com.dangsan.sinsa.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class LoginDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
