package by.it_academy.web.controller.handler;

import by.it_academy.service.service.validation.exception.EmployeeNotAddException;
import by.it_academy.service.service.validation.exception.IdNotFoundException;
import by.it_academy.web.controller.handler.error.EError;
import by.it_academy.web.controller.handler.error.ErrorResponse;
import by.it_academy.web.controller.handler.error.StructuredError;
import by.it_academy.web.controller.handler.error.StructuredErrorResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StructuredErrorResponse> onConstraintViolationException(ConstraintViolationException ex) {
        List<StructuredError> errors = ex.getConstraintViolations().stream()
                .map(violation -> {
                    String message = violation.getMessage();
                    String fullPath = violation.getPropertyPath().toString();
                    fullPath = fullPath.contains(".")
                            ? fullPath.substring(fullPath.lastIndexOf('.') + 1)
                            : fullPath;
                    return new StructuredError(fullPath, message);
                }).toList();

        StructuredErrorResponse structuredErrorResponse = new StructuredErrorResponse(EError.STRUCTURED_ERROR, errors);
        log.error("Argument annotated with fails.Errors: {}", errors, ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(structuredErrorResponse);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorResponse> onIdNotFoundException(IdNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(EError.ERROR, ex.getMessage());
        log.error("Object with id not found: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(EmployeeNotAddException.class)
    public ResponseEntity<ErrorResponse> onEmployeeNotAddException(EmployeeNotAddException ex) {
        ErrorResponse errorResponse = new ErrorResponse(EError.ERROR, ex.getMessage());
        log.error("The employee has already been added to the specified project: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<List<ErrorResponse>> onNoResourceFoundException(NoResourceFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(EError.ERROR, exception.getMessage());
        log.error("ResourceHttpRequestHandler can not find a resource: {}", exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(List.of(errorResponse));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<List<ErrorResponse>> onHttpMessageNotReadableException (HttpMessageNotReadableException exception) {
        ErrorResponse errorResponse = new ErrorResponse(EError.ERROR,
                "Data type transmitted in the request does not meet requirements");
        log.error("The HttpMessageConverter. read method fails: {}", exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(List.of(errorResponse));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<List<ErrorResponse>> onHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException exception) {
        ErrorResponse errorResponse = new ErrorResponse(EError.ERROR, exception.getMessage());
        log.error("Request handler does not support a specific request method, error: {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(List.of(errorResponse));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<List<ErrorResponse>> onException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse(EError.ERROR,
                "Server failed to process request correctly. Please try later or contact administrator");
        log.error("Exception. Error: {}", exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(errorResponse));
    }
}
