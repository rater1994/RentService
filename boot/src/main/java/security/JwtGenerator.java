package security;

import com.rent.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public String generate(User user) {

        Claims claims = Jwts.claims()
                .setSubject(user.getUsername());
        claims.put("userId",String.valueOf(user.getId()));
        claims.put("role", user.getRoles());


       return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,"youtube")
                .compact();
    }
}
