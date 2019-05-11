package com.lambdaschool.todo.controller;

import com.lambdaschool.todo.model.ToDo;
import com.lambdaschool.todo.model.User;
import com.lambdaschool.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController
{
    @Autowired
    private ToDoService toDoService;

    @PutMapping("/todoid/{todoid}")
    public ResponseEntity<?> addNewUser(@RequestBody ToDo updatedToDo, @PathVariable long todoid)
    {
        return new ResponseEntity<>(toDoService.update(updatedToDo, todoid), HttpStatus.OK);
    }
}
