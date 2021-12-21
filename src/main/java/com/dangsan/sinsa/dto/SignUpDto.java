package com.dangsan.sinsa.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

import java.time.LocalDateTime;

@Data
public class SignUpDto {

    @NotBlank(message = "username 입력은 필수입니다.")
    @Length(min = 2, max = 50)
    private String username;
    // 아이디

    @NotBlank
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{6,18}",
            message = "비밀번호는 영문자(대소문자)와 숫자, 특수기호가 적어도 1개 이상 포함된 6자~18자의 비밀번호여야 합니다.")
    private String password;

    @NotBlank
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9_-]{3,20}$")
    private String nickname;
    // 별명

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일 입력은 필수입니다.")
    private String email;
}
