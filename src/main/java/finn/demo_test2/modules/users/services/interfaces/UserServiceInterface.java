package finn.demo_test2.modules.users.services.interfaces;

import finn.demo_test2.modules.requests.LoginRequest;

public interface UserServiceInterface {
  Object authenticate(LoginRequest request);
}
