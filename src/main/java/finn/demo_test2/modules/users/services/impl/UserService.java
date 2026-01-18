package finn.demo_test2.modules.users.services.impl;

import org.springframework.stereotype.Service;

import finn.demo_test2.modules.users.dtos.LoginRequest;
import finn.demo_test2.modules.users.dtos.LoginResponse;
import finn.demo_test2.modules.users.dtos.UserDTO;
import finn.demo_test2.modules.users.services.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {
  @Override
  public LoginResponse login(LoginRequest request) {
    try {
      String token = "random_token";
      UserDTO user = new UserDTO(1L, "test1@gmail.com");
      return new LoginResponse(token, user);
    } catch (Exception e) {
      throw new RuntimeException("Error");
    }
  }
}
