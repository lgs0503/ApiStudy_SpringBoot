package com.lgs.todo.repository;

import com.lgs.todo.entitiy.Todo;

import java.util.List;

public interface TodoRepositoryCustom {

    List<Todo> searchList(Todo banner);
    Long searchListCount(Todo banner);
    Todo search(Long idx);
}