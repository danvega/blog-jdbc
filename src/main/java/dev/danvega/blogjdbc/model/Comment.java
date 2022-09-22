package dev.danvega.blogjdbc.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Comment(@Id Integer id, String content, Post post, Author author, LocalDateTime publishedOn, LocalDateTime updatedOn) {

}
