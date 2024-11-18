package com.example.demo.domain.member.service;

import com.example.demo.constant.MemberRole;
import com.example.demo.domain.member.dto.Member.SignupReqDto;
import com.example.demo.domain.member.entities.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;

    public void signup(SignupReqDto signupReqDto) {
        // 비밀번호 암호화
        String encodedPassword = bcryptPasswordEncoder.encode(signupReqDto.getPassword());

        Member signupMember = Member.builder()
                .userName(signupReqDto.getUserName())
                .name(signupReqDto.getName())
                .birth(signupReqDto.getBirth())
                .tel(signupReqDto.getTel())
                .email(signupReqDto.getEmail())
                .password(encodedPassword)  // 암호화된 비밀번호 저장
                .role(MemberRole.USER) // 기본 role은 USER로 설정
                .build();

        memberRepository.save(signupMember);
    }

//    public boolean login(String username, String password) {
//        Member member = memberRepository.findByUserName(username)
//                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
//
//        // 입력된 비밀번호와 저장된 비밀번호를 비교
//        return bcryptPasswordEncoder.matches(password, member.getPassword());
//    }

    public boolean isMember(String userName){
        return memberRepository.countByUserName(userName) == 0;
    }
}

