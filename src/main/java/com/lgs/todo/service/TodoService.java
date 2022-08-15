package com.lgs.todo.service;


import com.lgs.todo.entitiy.Todo;

import java.util.List;

public interface TodoService {

    public List<Todo> searchList(Todo todo);
    public Long searchListCount(Todo todo);
    public Todo search(Long idx);

    public void insert(Todo todo);
    public void update(Todo todo);
    public void delete(Todo todo);
    public void deleteAll();


}
