package com.lgs.todo.service;

import com.lgs.todo.entitiy.Todo;
import com.lgs.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> searchList(Todo todo) {
        return todoRepository.searchList(todo);
    }

    @Override
    public Long searchListCount(Todo todo) {
        return todoRepository.searchListCount(todo);
    }

    @Override
    public Todo search(Long idx) {
        return (Todo) todoRepository.findAllById(Collections.singleton(idx));
    }

    @Override
    public void insert(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void update(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void delete(Todo todo) {
        todoRepository.delete(todo);
    }
}
