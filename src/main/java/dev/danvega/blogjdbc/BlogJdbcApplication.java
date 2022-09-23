package dev.danvega.blogjdbc;

import dev.danvega.blogjdbc.model.Author;
import dev.danvega.blogjdbc.model.Comment;
import dev.danvega.blogjdbc.model.Post;
import dev.danvega.blogjdbc.repository.AuthorRepository;
import dev.danvega.blogjdbc.repository.CommentRepository;
import dev.danvega.blogjdbc.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class BlogJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogJdbcApplication.class, args);
	}

	@Bean
	CommandLineRunner run(PostRepository postRepository, AuthorRepository authorRepository, CommentRepository commentRepository) {
		return args -> {
			Author dan = authorRepository.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega"));
			Author greg = authorRepository.save(new Author(null, "Greg", "Turnquist", "gturnquist@gmail.com","gturnquist"));

			Post post1 = new Post(null, "Dan's First Post", "This is Dan's First Post", dan.id(), LocalDateTime.now(), LocalDateTime.now());
			Post post2 = new Post(null, "Greg's First Post", "This is Greg's First Post", greg.id(), LocalDateTime.now(), LocalDateTime.now());
			postRepository.saveAll(List.of(post1,post2));

			// add comments to post
			Post p1 = postRepository.findByTitle("Dan's First Post");
			Comment comment1 = new Comment(null, "Dan", "This is a comment", p1.getId(), LocalDateTime.now(), LocalDateTime.now());
			Comment comment2 = new Comment(null, "John", "This is a another comment", p1.getId(), LocalDateTime.now(), LocalDateTime.now());
			commentRepository.saveAll(List.of(comment1,comment2));

			postRepository.findAll().forEach(System.out::println);
			System.out.println("-------------------");
			postRepository.findAllByAuthorId(dan.id()).forEach(System.out::println);
		};
	}

}
