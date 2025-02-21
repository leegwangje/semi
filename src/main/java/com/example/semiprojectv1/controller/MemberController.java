package com.example.semiprojectv1.controller;

import com.example.semiprojectv1.domain.MemberDTO;
import com.example.semiprojectv1.repository.MemberRepository;
import com.example.semiprojectv1.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join() {
        return "views/member/join";
    }

    @GetMapping("/login")
    public String login() {

        return "views/member/login";
    }

    @GetMapping("/myinfo")
    public String myinfo() {

        return "views/member/myinfo";
    }

    @PostMapping ("/join")
    public String joinook(MemberDTO member) {

        String returnPage = "redirect:/member/error";

        log.info("submit된 회원 정보 : {}", member);

        if(memberService.newMember(member))
            returnPage = "redirect:/member/login";

        return returnPage;
    }

}
