package com.lambdaschool.todo.controller;

import com.lambdaschool.todo.model.User;

import com.lambdaschool.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
