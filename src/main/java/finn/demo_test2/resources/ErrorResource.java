package finn.demo_test2.resources;

import java.util.Map;

public class ErrorResource {
  private String message;
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  private Map<String, String> errors;
  public ErrorResource(String message, Map<String, String> errors) {
    this.message = message;
    this.errors = errors;
  }
  public Map<String, String> getErrors() {
    return errors;
  }
  public void setErrors(Map<String, String> errors) {
    this.errors = errors;
  }
}
