package com.dangsan.sinsa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @JsonIgnore
    @Id @GeneratedValue
    @Column(name="user_id")
    private Long id;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    @Column(unique = true)
    private String nickname;

    private String area;

    private LocalDateTime birth;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private Boolean status;

}
