package com.example.demo.domain.member.controller;

import com.example.demo.domain.member.dto.Member.SignupReqDto;
import com.example.demo.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping ("/login")
    public String loginPage() throws Exception{
        return "/page/user/loginPage";
    }
    @GetMapping("/user/board")
    public String userBoard() throws Exception{
        return "/page/user/board";
    }
    @GetMapping("/admin/board")
    public String adminBoard() throws Exception{
        return "/page/admin/board";
    }
    @GetMapping("/user/join")
    public String signup() throws Exception{
        return "/page/user/join/signup";
    }
    @GetMapping("/user/signupSuccess")
    public String signupSuccess() throws Exception{
        return "/page/user/join/signupSuccess";
    }
    @PostMapping ("/user/join")
    public String memberJoin(Model model, @ModelAttribute SignupReqDto signupReqDto) throws Exception{
        try {
            memberService.signup(signupReqDto); // 회원가입 로직
            return "redirect:/user/signupSuccess"; // 회원가입 성공 시 성공 페이지로 리다이렉트
        } catch (Exception e){
            model.addAttribute("errorMessage","회원가입에 실패했습니다."+e.getMessage());
            return "user/join/signup";
        }
    }
}
