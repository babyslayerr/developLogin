package com.example.marineinformation.Auth.dto;

import com.example.marineinformation.entities.MemberEntity;
import lombok.Getter;

@Getter
public class MemberDto {
    private String username;
    private String password;


    public MemberEntity to(){

        return MemberEntity.builder()
                .username(username)
                .password(password)
                .build();
    }
}
