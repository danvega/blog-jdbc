package dev.danvega.blogjdbc.repository;

import dev.danvega.blogjdbc.model.Author;
import dev.danvega.blogjdbc.model.Comment;
import dev.danvega.blogjdbc.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    AuthorRepository authorRepository;

    AggregateReference<Author,Integer> author;

    @BeforeEach
    void setUp() {
        author = AggregateReference.to(authorRepository.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega")).id());
    }

    @Test
    void testPostWithComments() {
        Post post = new Post( "Dan's First Post", "This is Dan's First Post",author);
        post.addComment(new Comment( "Dan", "This is a comment", LocalDateTime.now(), LocalDateTime.now()));
        post.addComment(new Comment( "John", "This is another comment", LocalDateTime.now(), LocalDateTime.now()));
        postRepository.save(post);

        Post first_post = postRepository.findById(post.getId()).get();
        first_post.showComments();
    }

}