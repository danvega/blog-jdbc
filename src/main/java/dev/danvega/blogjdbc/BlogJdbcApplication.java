package dev.danvega.blogjdbc;

import dev.danvega.blogjdbc.model.Author;
import dev.danvega.blogjdbc.model.Comment;
import dev.danvega.blogjdbc.model.Post;
import dev.danvega.blogjdbc.repository.AuthorRepository;
import dev.danvega.blogjdbc.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;

@SpringBootApplication
public class BlogJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogJdbcApplication.class, args);
	}

	@Bean
	CommandLineRunner run(PostRepository postRepository, AuthorRepository authorRepository) {
		return args -> {
			AggregateReference<Author,Integer> author = AggregateReference.to(authorRepository.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega")).id());

			Post post = new Post( "Dan's First Post", "This is Dan's First Post",author);
			post.addComment(new Comment( "Dan", "This is a comment", LocalDateTime.now(), LocalDateTime.now()));
			post.addComment(new Comment( "John", "This is another comment", LocalDateTime.now(), LocalDateTime.now()));
			postRepository.save(post);
		};
	}

}
