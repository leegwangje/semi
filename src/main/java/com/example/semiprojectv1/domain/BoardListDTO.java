package com.example.semiprojectv1.domain;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardListDTO {
    private int cpg;
    private int stblk;
    private int cntpg;
    private int edblk;
    private List<?> bdlist;

    public BoardListDTO(int cpg, int totalItems ,int pageSize, List<?> bdlist) {
        this.cpg = cpg;
        this.cntpg = (int)Math.ceil((double) totalItems / pageSize);   // 총 페이지 구하는 식
        this.bdlist = bdlist;
        // 페이지네이션 범위계산
        this.stblk = ((cpg-1) /10) *10 +1;
        this.edblk = Math.min(stblk + 10 -1, cntpg);
    }
}
