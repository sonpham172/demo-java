package finn.demo_test2.services;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import finn.demo_test2.config.JwtConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
  private final JwtConfig jwtConfig;
  private final SecretKey secretKey;

  public JwtService(JwtConfig jwtConfig) {
    this.jwtConfig = jwtConfig;
    // Use raw bytes for the secret key, not Base64 encoded
    this.secretKey = Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());
  }

  public String generateToken(Long userId, String email) {
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + jwtConfig.getExpiration());

    return Jwts.builder()
            .subject(String.valueOf(userId))
            .claim("email", email)
            .issuedAt(now)
            .expiration(expiryDate)
            .signWith(secretKey) // Use modern API without deprecated SignatureAlgorithm
            .compact();
  }
}
