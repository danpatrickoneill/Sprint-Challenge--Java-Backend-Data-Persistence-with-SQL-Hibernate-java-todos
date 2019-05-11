package com.lambdaschool.todo.service;

import com.lambdaschool.todo.model.ToDo;

public interface ToDoService
{
    ToDo findToDoById(long id);

    ToDo update(ToDo toDo, long id);
}
