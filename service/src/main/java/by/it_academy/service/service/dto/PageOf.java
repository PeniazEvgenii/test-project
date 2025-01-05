package by.it_academy.service.service.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@FieldNameConstants
public class PageOf <T> {
    private final int number;

    private final int size;

    private final int totalPages;

    private final long totalElements;

    private final boolean first;

    private final int numberOfElements;

    private final boolean last;

    private final List<T> content;

    public static <T> PageOf<T> of (Page<T> page) {
        return new PageOf<T>(
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.isFirst(),
                page.getNumberOfElements(),
                page.isLast(),
                page.getContent()
        );
    }

}
