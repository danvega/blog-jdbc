package dev.danvega.blogjdbc.repository;

import dev.danvega.blogjdbc.model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authors;

    Author author;

    @BeforeEach
    void setUp() {
        author = authors.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega"));
    }

    @Test
    void shouldReturnAllAuthors() {
        long count = StreamSupport.stream(authors.findAll().spliterator(), false).count();
        assertEquals(1, count);
    }

}