package finn.demo_test2.modules.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {
  @NotBlank(message = "Email should not blank")
  @Email(message = "Email is invalid")
  private String email;

  @NotBlank(message = "Password should not blank")
  @Size(min = 4)
  private String password;

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
