package finn.demo_test2.modules.users.services.impl;

import org.springframework.stereotype.Service;

import finn.demo_test2.modules.requests.LoginRequest;
import finn.demo_test2.modules.users.resources.LoginResource;
import finn.demo_test2.modules.users.resources.UserResource;
import finn.demo_test2.modules.users.services.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {
  @Override
  public LoginResource login(LoginRequest request) {
    try {
      String token = "random_token";
      UserResource user = new UserResource(2L, "test1@gmail.com");
      return new LoginResource(token, user);
    } catch (Exception e) {
      throw new RuntimeException("Error");
    }
  }
}
