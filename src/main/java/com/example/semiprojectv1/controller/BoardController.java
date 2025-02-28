package com.example.semiprojectv1.controller;

import com.example.semiprojectv1.repository.BoardRepository;
import com.example.semiprojectv1.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String index(Model m,@RequestParam(defaultValue = "1") int cpg) {
        // RequestParam에 defaultValue를 이용하면
        // cpg 매개변수가 전달되지 않을 경우 기본값인 1이 전달됨

        log.info("board/list 호출 !");

        m.addAttribute("bds", boardService.readBoard(cpg));
        m.addAttribute("cpg", cpg);
        m.addAttribute("stblk", ((cpg - 1) / 10) * 10 + 1);     // 시작위치
        m.addAttribute("cntpg", boardService.countBoard());
        return "views/board/list";
    }
    @GetMapping("/find")
    public String find(Model m, String findtype, String findkey,
           @RequestParam(defaultValue = "1") int cpg) {

        m.addAttribute("bds", boardService.findBoard(cpg,findtype,findkey));
        m.addAttribute("cpg", cpg);
        m.addAttribute("stblk", ((cpg - 1) / 10) * 10 + 1);
        m.addAttribute("cntpg", boardService.countfindBoard(findtype,findkey));
        return "views/board/list";
    }

    @GetMapping("/view")
    public String view(Model m,int bno) {

        m.addAttribute("bd", boardService.readOneBoard(bno));

        return "views/board/view";
    }
}
