package dev.danvega.blogjdbc.controller;

import dev.danvega.blogjdbc.model.Post;
import dev.danvega.blogjdbc.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

}
