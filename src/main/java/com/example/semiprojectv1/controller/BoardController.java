package com.example.semiprojectv1.controller;

import com.example.semiprojectv1.domain.NewBoardDTO;
import com.example.semiprojectv1.domain.NewReplyDTO;
import com.example.semiprojectv1.service.BoardService;
import com.example.semiprojectv1.service.GoogleRecaptchaService;
import com.example.semiprojectv1.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final GoogleRecaptchaService googleRecaptchaService;
    private final MemberService memberService;

    @GetMapping("/list")
    public String list(HttpServletResponse response) {
        // 클라이언트 캐시 제어
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        log.info("board/list 호출!!");

        return "views/board/list";
    }
    @GetMapping("/find")
    public String find() {

        return "views/board/list";
    }

    @GetMapping("/view")
    public String view() {

        return "views/board/view";
    }

    @GetMapping("/write")
    public String write(Model m, Authentication authentication) {
        String returnPage = "redirect:/member/login";

        if(authentication != null && authentication.isAuthenticated()) {

            m.addAttribute("sitekey", System.getenv().get("recaptcha_sitekey"));
            returnPage= "views/board/write";
        }

        return returnPage;
    }

    @PostMapping( "/write")
    public ResponseEntity<?> writeok(NewBoardDTO newBoardDTO,
                                     @RequestParam("g-recaptcha-response")   String gRecaptchaResponse ) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();
        log.info("submit된 게시글 정보 : {}",newBoardDTO);
        log.info("submit된 recaptcha 응답코드 : {}",gRecaptchaResponse);

        try {
            if (!googleRecaptchaService.verifyRecaptcha(gRecaptchaResponse)) {
                throw new IllegalStateException("자동가입방지 코드 오류!!!");

            }

            if(boardService.newBoard(newBoardDTO)) {
                response =  ResponseEntity.ok().build();
            }
        }catch (IllegalStateException ex){
            response=ResponseEntity.badRequest().body(ex.getMessage());
        }

        return response;
    }

    @PostMapping("/reply")
    public String replyok(NewReplyDTO newReplyDTO) {
        String returnPage = "redirect:/board/view?bno=" + newReplyDTO.getPno();

        if (!boardService.newReply(newReplyDTO)) {
            returnPage = "redirect:/board/error?type=1";
        }

        return returnPage;
    }

    @PostMapping("/cmmt")
    public String cmmtok(NewReplyDTO newReplyDTO) {
        String returnPage = "redirect:/board/view?bno=" + newReplyDTO.getPno();

        if (!boardService.newComment(newReplyDTO)) {
            returnPage = "redirect:/board/error?type=1";
        }

        return returnPage;
    }


}
