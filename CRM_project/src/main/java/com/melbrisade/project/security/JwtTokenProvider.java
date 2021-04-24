package com.melbrisade.project.security;

import com.melbrisade.project.entities.Users;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.melbrisade.project.security.SecurityConstant.EXPIRATION_TIME;
import static com.melbrisade.project.security.SecurityConstant.SECRET;

@Component
public class JwtTokenProvider {

    // Generate the token
    public String generateToken(Authentication authentication) {
        Users users = (Users) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        String userId = Long.toString(users.getId());
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",(Long.toString(users.getId())));
        claims.put("username", users.getUsername());
        claims.put("email", users.getEmail());
        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    // Validate the token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex) {
            System.out.println("Invalid JWT Signature");
        }catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT Token");
        }catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT Token");
        }catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token");
        }catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty");
        }
        return false;
    }

    // Get User Id from token
    public long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String id = (String)claims.get("id");

        return Long.parseLong(id);
    }
}
