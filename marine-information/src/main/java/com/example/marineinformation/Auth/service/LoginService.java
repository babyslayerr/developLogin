package com.example.marineinformation.Auth.service;

import com.example.marineinformation.Auth.dto.MemberDto;
import com.example.marineinformation.repository.MemberRepository;
import com.example.marineinformation.entities.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public String join(MemberDto memberDto) {

        memberRepository.save(memberDto.to());
        return "success";
    }

    public MemberEntity login(MemberDto memberDto){

        Optional<MemberEntity> optionalMember = memberRepository.findByUsernameAndPassword(memberDto.getUsername(),memberDto.getPassword());
        MemberEntity member = optionalMember.orElse(null);
        if(member == null){
            return null;
        }

        return member;

    }

}
