package APIGateWay.APIGateWay.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "1cbaee3794baa86215098188f54d3adaaefc3c7b49ed28dc475cc29a4ac4fe05";

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractId(String token) {
        return extractClaim(token, claims -> claims.get("id", String.class));
    }
    public String extractRoles(String token) {;
        return extractClaim(token, claims -> claims.get("role", String.class));
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }

    public boolean validateToken(String token, String email) {
        return email.equals(extractEmail(token));
    }
}