package com.lgs.todo.controller;

import com.lgs.comm.HttpHeaderJsonType;
import com.lgs.comm.HttpMessage;
import com.lgs.todo.entitiy.Todo;
import com.lgs.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity searchList(Todo todo){
        HttpMessage message = new HttpMessage();

        try{
            message.put("data", todoService.searchList(todo));
            message.put("count", todoService.searchListCount(todo));
        } catch(Exception e){
            message.setStatus("404");
        }

        return ResponseEntity.ok()
                .headers(HttpHeaderJsonType.getHeader())
                .body(message.getMessage());
    }

    @GetMapping("/{idx}")
    public ResponseEntity search(@PathVariable Long idx){
        HttpMessage message = new HttpMessage();

        try{
            message.put("data", todoService.search(idx));
        } catch(Exception e){
            message.setStatus("404");
        }

        return ResponseEntity.ok()
                .headers(HttpHeaderJsonType.getHeader())
                .body(message.getMessage());
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody Todo todo){
        HttpMessage message = new HttpMessage();

        try{
            todo = Todo.builder()
                    .title(todo.getTitle())
                    .content(todo.getContent())
                    .createUser(todo.getCreateUser())
                .build();

            todoService.insert(todo);
        } catch(Exception e){
            message.setStatus("404");
        }

        return ResponseEntity.ok()
                .headers(HttpHeaderJsonType.getHeader())
                .body(message.getMessage());
    }

    @PatchMapping
    public ResponseEntity update(@RequestBody Todo todo){
        HttpMessage message = new HttpMessage();

        try{

            if (todo.getIdx() == 0 ){
                throw new Exception();
            }

            todo = Todo.builder()
                    .idx(todo.getIdx())
                    .title(todo.getTitle())
                    .content(todo.getContent())
                    .createUser(todo.getCreateUser())
                    .build();

            Long count = todoService.searchListCount(todo);

            if (count > 0) {
                todoService.update(todo);
            } else {
                throw new Exception();
            }

        } catch(Exception e){
            message.setStatus("404");
        }

        return ResponseEntity.ok()
                .headers(HttpHeaderJsonType.getHeader())
                .body(message.getMessage());
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Todo todo){
        HttpMessage message = new HttpMessage();

        try{
            todoService.delete(todo);
        } catch(Exception e){
            message.setStatus("404");
        }

        return ResponseEntity.ok()
                .headers(HttpHeaderJsonType.getHeader())
                .body(message.getMessage());
    }

    @DeleteMapping("/all")
    public ResponseEntity deleteAll(){
        HttpMessage message = new HttpMessage();

        try{
            todoService.deleteAll();
        } catch(Exception e){
            message.setStatus("404");
        }

        return ResponseEntity.ok()
                .headers(HttpHeaderJsonType.getHeader())
                .body(message.getMessage());
    }
}