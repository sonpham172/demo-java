package finn.demo_test2.modules.users.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import finn.demo_test2.databases.seeder.DatabaseSeeder;
import finn.demo_test2.modules.requests.LoginRequest;
import finn.demo_test2.modules.users.entities.User;
import finn.demo_test2.modules.users.repositories.UserRepository;
import finn.demo_test2.modules.users.resources.LoginResource;
import finn.demo_test2.modules.users.resources.UserResource;
import finn.demo_test2.modules.users.services.interfaces.UserServiceInterface;
import finn.demo_test2.resources.ErrorResource;
import finn.demo_test2.services.JwtService;

@Service
public class UserService implements UserServiceInterface {
  private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);

  @Autowired
  private JwtService jwtService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @Override
  public Object authenticate(LoginRequest request) {
    try {
      User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new
      BadCredentialsException("Invalid authentication"));

      Long id = user.getId();
      String email = user.getEmail();
      String password = user.getPassword();

      if(!passwordEncoder.matches(request.getPassword(), password)) {
        throw new BadCredentialsException("Invalid authentication");
      }

      String token = jwtService.generateToken(id, email);
      UserResource userResource = new UserResource(id, email, user.getName());
      return new LoginResource(token, userResource);
    } catch (BadCredentialsException e) {
      logger.error("error", e.getMessage());
      Map<String, String> errors = new HashMap<>();
      errors.put("message", e.getMessage());
      ErrorResource errorResource = new ErrorResource("Invalid authentication", errors);
      return errorResource;
    }
  }
}
