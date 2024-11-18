package com.example.demo.domain.member.dto.Member;

import com.example.demo.domain.member.entities.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SignupReqDto {

    private String userName;
    private String password;
    private String name;
    private LocalDate birth;
    private String tel;
    private String email;

}
