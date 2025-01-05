package by.it_academy.web.controller.handler.error;

import lombok.Data;

@Data
public class StructuredError {

    private final String field;

    private final String message;
}
