package com.example.demo.security;

import com.example.demo.domain.member.entities.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import com.example.demo.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 데이터베이스에서 사용자 조회
        Member member = memberRepository.findByUserName(username);
        if (member == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // 조회된 사용자 정보를 CustomUserDetails로 변환
        return new CustomUserDetails(
                member.getUserName(),
                member.getPassword(),
                member.getRole().toString() // 사용자의 권한 정보
        );
    }
}
