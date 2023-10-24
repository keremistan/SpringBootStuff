package de.cegos.springproject1.repository;

import de.cegos.springproject1.Todo;
import org.springframework.data.repository.ListCrudRepository;

public interface TodoRepository extends ListCrudRepository<Todo, Long> {

    public Todo findByDescription(String description);

}
