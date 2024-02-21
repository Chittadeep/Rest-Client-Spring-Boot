package com.example.RestClientSpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.RestClientSpringBoot.Model.Todo;

@Service
public class TodoService {

    @Autowired
    private RestClient restClient;

    public List<Todo> getAllTodos()
    {
        return restClient.get().uri("todos").retrieve().body(new ParameterizedTypeReference<List<Todo>>(){});
    }

    public Todo getTodo(int id)
    {
        return restClient.get().uri("todos/{id}", id).retrieve().onStatus(HttpStatusCode.valueOf(500)->
        {throw new RuntimeException("No todo with the given id exists");}).body(Todo.class);
    }
}
