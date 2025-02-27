package com.example.semiprojectv1.board;


import com.example.semiprojectv1.domain.BoardDTO;
import com.example.semiprojectv1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.TestConstructor;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@MybatisTest
@RequiredArgsConstructor   // final 필드변수를 생성자 생성
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)   // 생성자 주입시 필요
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)  // H2 데이터베이스 사용중지
public class BoardMapperTest {

    // autowired가 아닌 생성자를 이용한 의존성 주입이 더 나음
    private final BoardRepository boardMapper;  // final 제거
    @Value("${board.page-size}") private int pageSize;

    @Test
    @DisplayName("BoardMapper select test")
    void selectTest() {
        // Given : 테스트에 사용할 데이터 제공
        int stnum=0;    // 조회할 게시물 시작위치

        // When : 테스트로 테스트할 기능 호출
        List<BoardDTO> result = boardMapper.selectBoard(stnum,pageSize);

        // Then : 호출되고 난 후 결과값 확인
        log.info("result: {}", result);  // 변수명 수정 (results → result)
        assertNotNull(result);
    }
}
