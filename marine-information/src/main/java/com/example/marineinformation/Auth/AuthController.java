package com.example.marineinformation.Auth;

import com.example.marineinformation.Auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;

    @PostMapping("/join")
    public String signUp(@RequestBody MemberDto memberDto){

        return loginService.join(memberDto);
    }

}
