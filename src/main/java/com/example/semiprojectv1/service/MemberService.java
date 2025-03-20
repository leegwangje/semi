package com.example.semiprojectv1.service;

import com.example.semiprojectv1.domain.MemberDTO;
import com.example.semiprojectv1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor    // 생성자 주입
public class MemberService {

    private final MemberRepository memberMapper;

    public boolean newMember(MemberDTO member) {
        int result = memberMapper.insertMember(member);
        return result == 1;     // 회원정보가 테이블 저장되었느지 여부에 따라
                                // true, false 반환
    }

}
