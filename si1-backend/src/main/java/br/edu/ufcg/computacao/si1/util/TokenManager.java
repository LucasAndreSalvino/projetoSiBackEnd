package br.edu.ufcg.computacao.si1.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenManager {

    public static final String KEY = "Ve7GLoDiKyX3f3XV";

    public static String getToken(String subject){
        String token = Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();

        return token;
    }

}
