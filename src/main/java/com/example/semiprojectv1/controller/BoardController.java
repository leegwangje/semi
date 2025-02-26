package com.example.semiprojectv1.controller;

import com.example.semiprojectv1.repository.BoardRepository;
import com.example.semiprojectv1.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String index(Model m) {
        log.info("board/list 호출 !");

        m.addAttribute("bds", boardService.readBoard());
        return "views/board/list";
    }
}
