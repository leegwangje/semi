package com.example.semiprojectv1.domain;

import lombok.Data;

@Data
public class MemberDTO {

    private String userid;
    private String passwd;
    private String repasswd;
    private String name;
    private String email;


}
