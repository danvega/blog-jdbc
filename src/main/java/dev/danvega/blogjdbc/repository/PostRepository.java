package dev.danvega.blogjdbc.repository;

import dev.danvega.blogjdbc.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Integer> {



}
