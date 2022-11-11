package com.example.marineinformation.security;

import com.example.marineinformation.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            log.info("jwt filter start------!");
            Cookie[] cookies = request.getCookies();
            Cookie token = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("authentication")) {
                    token = cookie;
                }
            }
            String jwt = token.getValue();

            // 토큰 검증
            if(jwtUtils.filterToken(jwt)){
                filterChain.doFilter(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            log.info("jwt filter end------!");
        }

    }
}
