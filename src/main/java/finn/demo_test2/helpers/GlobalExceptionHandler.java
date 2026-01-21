package finn.demo_test2.helpers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import finn.demo_test2.resources.ErrorResource;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> hanleValidException(MethodArgumentNotValidException exception) {
    Map<String, String> errors = new HashMap<>();
    System.out.println("Test global");
    exception.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    ErrorResource errorResources = new ErrorResource("Something went wrong", errors);

    return new ResponseEntity<>(errorResources, HttpStatus.UNPROCESSABLE_CONTENT);
  }
}
