package dev.danvega.blogjdbc;

import dev.danvega.blogjdbc.model.Author;
import dev.danvega.blogjdbc.model.Post;
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
	CommandLineRunner run(PostRepository repository) {
		return args -> {
			Author dan = new Author(null, "Dan", "Vega", "danvega@gmail.com");
			Author greg = new Author(null, "Greg", "Turnquist", "gturnquist@gmail.com");

			Post post1 = new Post(null, "Dan's First Post", "This is Dan's First Post", dan, LocalDateTime.now(), LocalDateTime.now());
			Post post2 = new Post(null, "Greg's First Post", "This is Greg's First Post", greg, LocalDateTime.now(), LocalDateTime.now());
			repository.saveAll(List.of(post1,post2));

			repository.findAll().forEach(System.out::println);
		};
	}

}
