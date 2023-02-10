package uz.evr.university_evr.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import uz.evr.university_evr.exceptions.ValidatorException;

import java.util.Date;

@Component
public class JwtProvider {

    public static final Long accessTokenLifeTime = 1000 * 60 * 60 * 5L;
    public static final Long refreshTokenLifeTime = 86400000L;
    private static final String secretKey = "thisIsSecretKey";

    public String generateToken(String username, boolean isAccess) {
        Date expiredDate = new Date(System.currentTimeMillis() + (isAccess ? accessTokenLifeTime : refreshTokenLifeTime));
        return Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            throw new ValidatorException("UNAUTORIZED");
        }
    }

    public void validateToken(String token) {
        Jwts
                .parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
    }

}
