package com.example.semiprojectv1.member;


import com.example.semiprojectv1.domain.Member;
import com.example.semiprojectv1.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)   // 생성자 주입시 필요
public class MemberControllerTest {


    private final MockMvc mockMvc;  // 타입 지정 수정
    private final MemberRepository memberMapper;

    @Test
    @DisplayName("/join Post request test")
    public void joinok() throws Exception {
        //Given
        String userid="abc1234";
        String passwd="987xyz";
        String name ="abc123";
        String email="abc123@gmailc.com";
        // When

        mockMvc.perform(post("/member/join")
                        .param("userid", "userid")
                        .param("password", "passwd")
                        .param("name", "name")
                        .param("email", "email"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/member/login"));

        // Then
       // Member member = memberMapper.findByUserid("userid");
        //assertThat(member).isNull();
        //assertThat(member.getMno()).isNull();
       // assertThat(member.getRegdate()).isNull();
        //assertThat(member.getName()).isEqualTo("abc1234");
        //assertThat(member.getEmail()).isEqualTo("abc123@gmail.com");

    }
}
