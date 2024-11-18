package com.example.demo.domain.member.entities;

import com.example.demo.base.TimeBaseEntity;
import com.example.demo.constant.MemberRole;
import com.example.demo.domain.member.dto.Member.MemberInfoResDto;
import com.example.demo.domain.member.dto.Member.SignupReqDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Table (name = "member")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Member extends TimeBaseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long userId;
    @Column (unique = true, nullable = false)
    private String userName;
    @Column (unique = true, nullable = false)
    private String name;
    @Column (nullable = false)
    private String password;
    @Column (nullable = false)
    private LocalDate birth;
    @Column (unique = true, nullable = false)
    private String tel;
    @Column (unique = true, nullable = false)
    private String email;
    @Enumerated (EnumType.STRING)
    private MemberRole role;

    public Member signup(SignupReqDto signupReqDto){
        return Member.builder()
                .userName(signupReqDto.getUserName())
                .name(signupReqDto.getName())
                .birth(signupReqDto.getBirth())
                .tel(signupReqDto.getTel())
                .email(signupReqDto.getEmail())
                .build();
    }
}
