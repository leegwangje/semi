package com.example.semiprojectv1.service;


import com.example.semiprojectv1.domain.Board;
import com.example.semiprojectv1.domain.BoardDTO;
import com.example.semiprojectv1.domain.NewBoardDTO;
import com.example.semiprojectv1.domain.NewReplyDTO;

import java.util.List;

public interface BoardService {

    List<BoardDTO> readBoard(int cpg);

    int countBoard();

    List<BoardDTO> findBoard(int cpg,String findtype,String findkey);

    int countfindBoard(String findtype,String findkey);

    Board readOneBoard(int bno);

    void readOneView(int bno);

    boolean newBoard(NewBoardDTO newBoardDTO);

    boolean newReply(NewReplyDTO newReplyDTO);


}
