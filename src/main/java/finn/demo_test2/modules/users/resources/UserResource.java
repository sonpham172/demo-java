package finn.demo_test2.modules.users.resources;

public class UserResource {
  private final String email;
  private final Long id;

  public UserResource(Long id, String email) {
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
