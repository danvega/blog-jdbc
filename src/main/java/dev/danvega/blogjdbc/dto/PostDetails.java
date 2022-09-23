package dev.danvega.blogjdbc.dto;

import dev.danvega.blogjdbc.model.Author;
import dev.danvega.blogjdbc.model.Post;

public record PostDetails(Post post, Author author) { }
