package dev.danvega.blogjdbc.controller;

import dev.danvega.blogjdbc.model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostControllerIntTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldFindOnePost() {
        ResponseEntity<Post> exchange = restTemplate.exchange("/api/posts/1", HttpMethod.GET, null, Post.class);
        Post post = exchange.getBody();
        assertNotNull(post);
    }

}