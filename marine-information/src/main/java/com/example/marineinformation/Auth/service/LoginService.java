package com.example.marineinformation.Auth.service;

import com.example.marineinformation.Auth.MemberDto;
import com.example.marineinformation.Auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public String join(MemberDto memberDto) {

        memberRepository.save(memberDto.to());
        return "success";
    }



}
