package com.example.semiprojectv1.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {

    private String userid;
    private String passwd;
    private String name;
    private String email;


}
