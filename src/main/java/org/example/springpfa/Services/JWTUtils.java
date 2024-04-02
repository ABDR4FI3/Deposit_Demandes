package org.example.springpfa.Services;


import io.jsonwebtoken.Jwts;
import org.example.springpfa.entities.User;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Component
public class JWTUtils {
    private SecretKey secretKey;
    private static final long ExpirationTime = 3_600_000 ; // how many milliseconds in 1 hour

    public JWTUtils(){
        String secretString = "5454878c454sc54s575c7s5c4s5c4c5s75cs5c7sc4s5c4s54cs57s57scs5754151sc";
        byte[] keyBytes = Base64.getDecoder().decode((secretString.getBytes(StandardCharsets.UTF_8)));
        this.secretKey =  new SecretKeySpec(keyBytes,"HmacSHA256");
    }

    public String generateToken(User user){
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis() + ExpirationTime))
                .signWith(secretKey)
                .compact();
    }
}

