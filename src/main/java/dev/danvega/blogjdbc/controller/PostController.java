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

    // using the DomainClassConverter
    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Post post) {
        return post;
    }

    @GetMapping("/{id}/details")
    public PostDetails getPostDetails(@PathVariable("id") Post post) {
        return new PostDetails(post,authors.findById(post.getAuthor().getId()).get());
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return posts.save(post);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable("id") Post post, @RequestBody Post updatedPost) {
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        return posts.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Post post) {
        posts.delete(post);
    }


}
