package user_service.user_service.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "1cbaee3794baa86215098188f54d3adaaefc3c7b49ed28dc475cc29a4ac4fe05";

    public String generateToken(String email, int userId,String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userId);
        claims.put("email", email);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 giờ
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    public Integer extractId(String token) {
        return (Integer) extractAllClaims(token).get("id");
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //BE extract ID from token
//    String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION).substring(7);
//    int userId = jwtUtil.extractId(token);
//    System.out.println("User ID từ token: " + userId);

}