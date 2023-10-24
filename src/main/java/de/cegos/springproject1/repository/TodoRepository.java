package de.cegos.springproject1.repository;

import de.cegos.springproject1.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TodoRepository extends ListCrudRepository<Todo, Long> {

    public Todo findByDescription(String description);

    @Query("select t from Todo t where t.id < %?1")
    public List<Todo> findPriorTodos(Long id);

}
