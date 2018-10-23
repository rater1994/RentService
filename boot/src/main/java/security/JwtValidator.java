package security;


import com.rent.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String secret = "youtube";

    public User validate(String token) {

        User user = null;

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            user = new User();

            user.setUsername(body.getSubject());
            user.setId((int) Long.parseLong((String) body.get("userId")));
            user.setRoles((String) body.get("role"));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return user;
    }
}
