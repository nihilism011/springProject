package com.example.demo.security;

import com.example.demo.domain.member.entities.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PrincipalDetails  implements UserDetails {

    private final Member member;

    public PrincipalDetails(Member member) {
        this.member = member;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Collection<GrantedAuthority> collect = new ArrayList<>();

        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole().toString();
            }
        });
        return collect;
    }
    @Override
    public String getPassword() {
        return member.getPassword();
    }
    @Override
    public String getUsername() {
        return member.getUserName();
    }
    // 계정이 만료되었는지?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //계정이 밴 처리 되어있는지?
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //계정 비밀번호 주기가 되었는지?
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //계정이 활성화 되어 있는지?
    @Override
    public boolean isEnabled() {
        // 작성 예시
        // 1년동안 로그인을 하지 않았을 경우 휴면 계정으로 전환하기로 했다면
        // 현재시간 - 마지막 로그인 시간 이 1년 초과 일 경우 false
        return true;
    }
}
