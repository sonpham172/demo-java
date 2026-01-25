package finn.demo_test2.modules.users.resources;

public class UserResource {
  private final String email;
  private final String name;
  private final Long id;

  public UserResource(Long id, String email, String name) {
    this.id = id;
    this.email = email;
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getName() {
    return this.name;
  }

  public Long getId() {
    return this.id;
  }
}
