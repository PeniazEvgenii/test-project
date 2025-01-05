package by.it_academy.service.service.validation.exception;

public class IdNotFoundException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Request contains incorrect ID";

    public IdNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
