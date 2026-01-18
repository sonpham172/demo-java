package finn.demo_test2.modules.users.dtos;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDTO {
  private final String email;
  private final Long id;

  public UserDTO(Long id, String email) {
    this.id = id;
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }

  public Long getId() {
    return this.id;
  }
}
