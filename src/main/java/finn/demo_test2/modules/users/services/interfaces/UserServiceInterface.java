package finn.demo_test2.modules.users.services.interfaces;

import finn.demo_test2.modules.users.dtos.LoginRequest;
import finn.demo_test2.modules.users.dtos.LoginResponse;

public interface UserServiceInterface {
  LoginResponse login(LoginRequest request);
}
