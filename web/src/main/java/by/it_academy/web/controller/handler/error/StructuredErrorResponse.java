package by.it_academy.web.controller.handler.error;

import lombok.Data;

import java.util.List;

@Data
public class StructuredErrorResponse {

    private final EError logRef;

    private final List<StructuredError> errors;
}
