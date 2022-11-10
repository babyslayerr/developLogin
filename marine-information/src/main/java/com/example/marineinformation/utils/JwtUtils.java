package com.example.marineinformation.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {

    private static final int EXPIRATION = 60 * 60 * 24;

    public String createToken(){
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "jwt");
        headers.put("alg","HS256");

        Map<String, Object> payloads = new HashMap<>();
        payloads.put("exp",EXPIRATION);
        payloads.put("name","whdghks619"); // userId


        Key key = Keys.hmacShaKeyFor("JungJongHwanIsPerfectPersonAndNoWeakSideAlthoughNowItsTimeToGo".getBytes(StandardCharsets.UTF_8));

        Date date = new Date(); // 토큰 만료 시간
        date.setTime(date.getTime() + EXPIRATION);
        String jwtToken = Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .setSubject("test")
                .setExpiration(date)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return jwtToken;
    }

}
