package dev.danvega.blogjdbc.controller;

import dev.danvega.blogjdbc.model.Post;
import dev.danvega.blogjdbc.repository.AuthorRepository;
import dev.danvega.blogjdbc.repository.CommentRepository;
import dev.danvega.blogjdbc.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;
    private final CommentRepository commentRepository;

    public PostController(PostRepository postRepository, AuthorRepository authorRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @GetMapping("/author/{id}")
    public Iterable<Post> findAllByAuthorId(@PathVariable Integer id) {
        return postRepository.findAllByAuthorId(id);
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id) {
        Post post = postRepository.findById(id).get();
        post.setAuthor(authorRepository.findById(post.getAuthorId()).get());
        post.setComments(commentRepository.findAllByPostId(id));
        return post;
    }

}
