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
			Author author = new Author(null, "Dan", "Vega", "danvega@gmail.com");
			Post post1 = new Post(null, "My First Post", "This is my first post", author, LocalDateTime.now(), LocalDateTime.now());
			Post post2 = new Post(null, "My Second Post", "This is my second post", author, LocalDateTime.now(), LocalDateTime.now());
			repository.saveAll(List.of(post1,post2));

			repository.findAll().forEach(System.out::println);
		};
	}

}
