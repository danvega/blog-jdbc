package dev.danvega.blogjdbc;

import dev.danvega.blogjdbc.model.Author;
import dev.danvega.blogjdbc.model.Post;
import dev.danvega.blogjdbc.repository.AuthorRepository;
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
	CommandLineRunner run(PostRepository postRepository, AuthorRepository authorRepository) {
		return args -> {
			Author dan = authorRepository.save(new Author(null, "Dan", "Vega", "danvega@gmail.com"));
			Author greg = authorRepository.save(new Author(null, "Greg", "Turnquist", "gturnquist@gmail.com"));

			Post post1 = new Post(null, "Dan's First Post", "This is Dan's First Post", dan.id(), LocalDateTime.now(), LocalDateTime.now());
			Post post2 = new Post(null, "Greg's First Post", "This is Greg's First Post", greg.id(), LocalDateTime.now(), LocalDateTime.now());
			postRepository.saveAll(List.of(post1,post2));

			postRepository.findAll().forEach(System.out::println);
		};
	}

}
