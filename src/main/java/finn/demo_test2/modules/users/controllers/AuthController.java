package finn.demo_test2.modules.users.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finn.demo_test2.modules.requests.LoginRequest;
import finn.demo_test2.modules.users.resources.LoginResource;
import finn.demo_test2.modules.users.services.interfaces.UserServiceInterface;
import finn.demo_test2.resources.ErrorResource;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("v1/auth")
public class AuthController {
  private final UserServiceInterface userService;

  public AuthController(UserServiceInterface userService) {
    this.userService = userService;
  }

  @PostMapping("login")
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
    Object result = userService.authenticate(request);
    if(result instanceof LoginResource loginResource) {
      return ResponseEntity.ok(loginResource);
    }

    if(result instanceof ErrorResource errorResource) {
      return ResponseEntity.unprocessableContent().body(errorResource);
    }

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Network error");
  }
}
