package com.example.RestClientSpringBoot.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.RestClientSpringBoot.Model.Todo;
import com.example.RestClientSpringBoot.Service.TodoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;    

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return new ResponseEntity<List<Todo>>(todoService.getAllTodos(), HttpStatus.OK);
    }
    
    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable int id) {
        return new ResponseEntity<Todo>(todoService.getTodo(id), HttpStatus.OK);
    }
}
