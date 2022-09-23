package dev.danvega.blogjdbc.repository;

import dev.danvega.blogjdbc.model.Author;
import dev.danvega.blogjdbc.model.Comment;
import dev.danvega.blogjdbc.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CommentRepository commentRepository;

    private Author dan;

    @BeforeEach
    void setUp() {
        dan = authorRepository.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega"));
    }

    @Test
    void shouldCreateNewPost() {
        Post post = new Post(null, "Dan's First Post", "This is Dan's First Post", dan.id(), LocalDateTime.now(), LocalDateTime.now());
        assertNull(post.id());
        Post savedPost = postRepository.save(post);
        assertNotNull(savedPost.id());
    }

//    @Test
//    void shouldLoadPostDetailsForSinglePost() {
//        Post post = postRepository.save(new Post(null, "Dan's First Post", "This is Dan's First Post", dan.id(), LocalDateTime.now(), LocalDateTime.now()););
//        Comment comment1 = new Comment(null, "Dan", "This is a comment", post.id(), LocalDateTime.now(), LocalDateTime.now());
//        Comment comment2 = new Comment(null, "John", "This is a another comment", post.id(), LocalDateTime.now(), LocalDateTime.now());
//        commentRepository.saveAll(List.of(comment1,comment2));
//
//        // how do I load the post, author and it's comments
//        Post firstPost = postRepository.findByTitle("Dan's First Post");
//        firstPost.setAuthor(authorRepository.findById(firstPost.authorId()).get());
//        firstPost.setComments(commentRepository.findAllByPostId(firstPost.id()));
//    }

}