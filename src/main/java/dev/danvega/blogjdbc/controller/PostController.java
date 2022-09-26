package dev.danvega.blogjdbc.controller;

import dev.danvega.blogjdbc.dto.PostDetails;
import dev.danvega.blogjdbc.model.Post;
import dev.danvega.blogjdbc.repository.AuthorRepository;
import dev.danvega.blogjdbc.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository posts;
    private final AuthorRepository authors;

    public PostController(PostRepository postRepository, AuthorRepository authorRepository) {
        this.posts = postRepository;
        this.authors = authorRepository;
    }

    @GetMapping
    public Iterable<Post> findAll() {
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Post post) {
        return post;
    }

    @GetMapping("/{id}/details")
    public PostDetails getPostDetails(@PathVariable("id") Post post) {
        return new PostDetails(post,authors.findById(post.getAuthor().getId()).get());
    }

}
