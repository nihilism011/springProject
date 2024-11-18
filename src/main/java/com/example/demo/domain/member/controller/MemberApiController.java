package com.example.demo.domain.member.controller;

import com.example.demo.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/user/isMember/{userName}")
    public boolean userIdCheck(@PathVariable String userName) throws Exception{
        return memberService.isMember(userName);
    }

}
