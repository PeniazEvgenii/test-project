package by.it_academy.service.service.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PageDto {

    @Min(value = 0, message = "Page number can't be negative")
    private final int page;

    @Min(value = 1, message = "The number of elements on a page must be at least 1")
    private final int size;
}
