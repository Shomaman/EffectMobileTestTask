package com.example.effectMobile.TestTask.security;

import com.nimbusds.jwt.SignedJWT;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.Instant;
import java.util.stream.Collectors;

@Component
public class TokenService {
    private final JwtEncoder jwtEncoder;

    public TokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(BankUserDetails bankUserDetails){
        Instant now = Instant.now();
        String scope = bankUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("http://localhost:8080/")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(3600))
                .subject(bankUserDetails.getUsername())
                .claim("scope", scope)
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String parseToken(String token) {
        try{
            SignedJWT decodedJWT  = SignedJWT.parse(token);
            String subject = decodedJWT.getJWTClaimsSet().getSubject();
            return subject;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    return null;}
}
