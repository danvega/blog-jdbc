package dev.danvega.blogjdbc.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authors;

    @Test
    void shouldReturnAllAuthors() {
        long count = StreamSupport.stream(authors.findAll().spliterator(), false).count();
        assertEquals(1, count);
    }

}