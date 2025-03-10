package com.example.semiprojectv1.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewGalleryImageDTO {
    private String imgname;
    private int gno;
    private int imgsize;



}
