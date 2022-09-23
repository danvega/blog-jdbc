package dev.danvega.blogjdbc.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Comment(
        @Id
        Integer id,
        String name,
        String content,
        Integer postId,
        LocalDateTime publishedOn,
        LocalDateTime updatedOn
) {

}
