package by.it_academy.service.service.validation.exception;

public class EmployeeNotAddException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "The employee has already been added to the specified project";

    public EmployeeNotAddException() {
        super(DEFAULT_MESSAGE);
    }

    public EmployeeNotAddException(String message) {
        super(message);
    }
}
