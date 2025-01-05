package by.it_academy.web.controller.handler.error;

import lombok.Data;

@Data
public class ErrorResponse {

    private final EError logRef;

    private final String message;
}
