package dev.danvega.blogjdbc.repository;

import dev.danvega.blogjdbc.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {


}
