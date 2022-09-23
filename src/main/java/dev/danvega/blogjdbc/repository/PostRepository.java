package dev.danvega.blogjdbc.repository;

import dev.danvega.blogjdbc.model.Post;
import dev.danvega.blogjdbc.model.PostDetails;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Integer> {

    List<Post> findAllByAuthorId(Integer authorId);

    Post findByTitle(String title);


}
