package com.example.semiprojectv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
