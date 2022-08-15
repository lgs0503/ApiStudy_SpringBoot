package com.lgs.todo.entitiy;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="todo")
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idx;

    private String title;

    private String content;

    private String createUser;

    private LocalDateTime createdDate = LocalDateTime.now();

    @Builder
    public Todo(long idx, String title, String content, String createUser) {
        this.idx = idx;
        this.title = title;
        this.content = content;
        this.createUser = createUser;
    }
}