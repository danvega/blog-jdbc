package dev.danvega.blogjdbc.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Post(
        @Id Integer id,
        String title,
        String content,
        Author author,
        LocalDateTime publishedOn,
        LocalDateTime updatedOn
) {

}
