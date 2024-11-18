package com.example.demo.security;

import com.example.demo.domain.member.entities.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public PrincipalDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 데이터베이스에서 사용자 조회
        Member member = memberRepository.findByUserName(username);
        if (member == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // 조회된 사용자 정보를 PrincipalDetails로 변환
        return new PrincipalDetails(member);
    }
}
