package com.lambdaschool.todo.service;

import com.lambdaschool.todo.model.ToDo;
import com.lambdaschool.todo.model.User;

import java.util.List;

public interface UserService
{

    List<User> findAll();

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    User update(User user, long id);

    List<ToDo> findToDosByUser();
}