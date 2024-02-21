package com.example.RestClientSpringBoot.Model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Todo implements Serializable{
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
