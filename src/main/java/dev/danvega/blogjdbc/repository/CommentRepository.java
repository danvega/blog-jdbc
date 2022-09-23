package dev.danvega.blogjdbc.repository;

import dev.danvega.blogjdbc.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Integer> {

    List<Comment> findAllByPostId(Integer postId);

}
