package com.example.demo.domain.member.dto.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class MemberInfoResDto {

    private String userName;
    private String userNickName;
    private String password;
    private LocalDate birth;
    private String tel;
    private String email;
}
