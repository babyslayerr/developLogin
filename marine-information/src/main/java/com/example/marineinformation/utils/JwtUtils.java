package com.example.marineinformation.utils;

import com.example.marineinformation.entities.MemberEntity;
import com.example.marineinformation.repository.MemberRepository;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtUtils {

    private static final int EXPIRATION = 60 * 60 * 24;

    private final MemberRepository memberRepository;
    private static final Key key = Keys.hmacShaKeyFor("JungJongHwanIsPerfectPersonAndNoWeakSideAlthoughNowItsTimeToGo".getBytes(StandardCharsets.UTF_8));
    public String createToken(){
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "jwt");
        headers.put("alg","HS256");

        Map<String, Object> payloads = new HashMap<>();
        payloads.put("exp",EXPIRATION);
        payloads.put("name","whdghks619"); // userId




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

    public boolean filterToken(String jwt) {
        String nameInDB = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()  // parser만듬
                .parseClaimsJws(jwt)
                .getBody()  // body가져옴 ex) header, payload, signature
                .get("name", String.class);

        Optional<MemberEntity> byUsername = memberRepository.findByUsername(nameInDB);
        return byUsername.isPresent();

    }
}
