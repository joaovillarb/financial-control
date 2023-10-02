package villar.financial.financialcontrol.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import villar.financial.financialcontrol.dataprovider.database.entity.Account;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Slf4j
@Service
public class JwtService {

    private final String secretKey;
    private final Long jwtExpirationInMinutes;

    public JwtService(@Value("${api.security.token.secret}") String secretKey,
                      @Value("${api.security.token.expiration-in-minutes}") Long jwtExpirationInMinutes) {
        this.secretKey = secretKey;
        this.jwtExpirationInMinutes = jwtExpirationInMinutes;
    }

    public String generateToken(Account account) {
        try {
            var algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer("API Pitang")
                    .withSubject(account.getLogin())
                    .withAudience(account.getId())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            log.error("Error to generate token jwt", ex);
            throw new IllegalArgumentException("Error to generate token jwt");
        }
    }

    public String extractUsername(String token) {
        try {
            var algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
                    .withIssuer("API Pitang")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            log.error("Token invalid or expired!", ex);
            throw new IllegalArgumentException("Unauthorized - invalid session");
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now()
                .plusMinutes(jwtExpirationInMinutes)
                .toInstant(ZoneOffset.of("-03:00"));
    }

}
