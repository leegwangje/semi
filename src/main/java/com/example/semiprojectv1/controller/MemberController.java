package com.example.semiprojectv1.controller;

import com.example.semiprojectv1.domain.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

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
        log.info("submit된 회원 정보 : {}", member);

        return "redirect:/member/login";
    }

}
