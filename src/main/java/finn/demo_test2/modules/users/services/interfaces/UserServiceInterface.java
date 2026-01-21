package finn.demo_test2.modules.users.services.interfaces;

import finn.demo_test2.modules.requests.LoginRequest;
import finn.demo_test2.modules.users.resources.LoginResource;

public interface UserServiceInterface {
  LoginResource login(LoginRequest request);
}
