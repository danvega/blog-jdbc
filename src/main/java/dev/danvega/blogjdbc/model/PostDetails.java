package dev.danvega.blogjdbc.model;

import java.util.List;

public record PostDetails(Author author, Post post, List<Comment> comments) {

}
