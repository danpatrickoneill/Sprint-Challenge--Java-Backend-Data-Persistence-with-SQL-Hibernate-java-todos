package com.lambdaschool.todo.controller;

import com.lambdaschool.todo.model.ToDo;
import com.lambdaschool.todo.model.User;

import com.lambdaschool.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/mine")
    public ResponseEntity<?> getPostsByUser()
    {
        return new ResponseEntity<>(userService.findToDosByUser(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers()
    {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User newUser)
    {
        newUser = userService.save(newUser);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/todo/{userid}")
    public ResponseEntity<?> addNewUser(@RequestBody ToDo newToDo, @PathVariable long userid)
    {
        newToDo = null;

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id)
    {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
