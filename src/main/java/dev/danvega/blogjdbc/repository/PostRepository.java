package dev.danvega.blogjdbc.repository;

import dev.danvega.blogjdbc.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Integer> {

    List<Post> findAllByAuthorId(Integer authorId);

}
