package com.example.marineinformation.Auth.controller;

import com.example.marineinformation.Auth.dto.MemberDto;
import com.example.marineinformation.Auth.service.LoginService;
import com.example.marineinformation.entities.MemberEntity;
import com.example.marineinformation.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;
    
    private final JwtUtils jwtUtils;

    @PostMapping("/join")
    public void join(@RequestBody MemberDto memberDto){

        loginService.join(memberDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody MemberDto memberDto,HttpServletRequest request ,HttpServletResponse response){
        MemberEntity result = loginService.login(memberDto);
        if(result == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "400";
        }
        else{
            String token = jwtUtils.createToken();
            response.addCookie(new Cookie("authentication",token));
            HttpSession session = request.getSession();
            session.setAttribute("authentication",result);
            response.setStatus(HttpServletResponse.SC_OK);
            return "200";
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession(false);
        if(Objects.isNull(session.getAttribute("authentication"))){
            response.setStatus(HttpServletResponse.SC_PROXY_AUTHENTICATION_REQUIRED);
        }
        else{
            session.invalidate();
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }



}
