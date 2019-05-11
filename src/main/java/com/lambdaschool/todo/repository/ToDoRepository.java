package com.lambdaschool.todo.repository;

import com.lambdaschool.todo.model.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long>
{
}
