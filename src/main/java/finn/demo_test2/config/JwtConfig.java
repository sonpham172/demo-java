package finn.demo_test2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
  @Value("${jwt.secret}")
  private String secretKey;
  public String getSecretKey() {
    return secretKey;
  }

  @Value("${jwt.expiration}")
  private long expiration;
  public long getExpiration() {
    return expiration;
  }
}
