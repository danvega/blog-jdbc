package dev.danvega.blogjdbc.repository;

import dev.danvega.blogjdbc.model.Post;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Integer> {

    @Query("SELECT * FROM POST WHERE author = :id")
    List<Post> findByAuthor(Integer id);

    //List<Post> findByAuthorLastNameIgnoreCase(String lastName);

}
