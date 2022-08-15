package com.lgs.todo.repository;

import com.lgs.todo.entitiy.QTodo;
import com.lgs.todo.entitiy.Todo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class TodoRepositoryCustomImpl implements TodoRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public TodoRepositoryCustomImpl(EntityManager em) {
        jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Todo> searchList(Todo todo) {

        QTodo qTodo = QTodo.todo;

        BooleanBuilder builder = new BooleanBuilder();
        builderCondition(builder, todo, qTodo);

        return jpaQueryFactory
                .select(qTodo)
                .from(qTodo)
                .where(builder)
                .fetch();
    }

    @Override
    public Long searchListCount(Todo todo) {

        QTodo qTodo = QTodo.todo;

        BooleanBuilder builder = new BooleanBuilder();
        builderCondition(builder, todo, qTodo);

        return  jpaQueryFactory
                .select(qTodo.count())
                .from(qTodo)
                .where(builder)
                .fetch()
                .get(0);//fetchCount() 대신 사용 - QueryDSL 패치되서 안씀
    }

    @Override
    public Todo search(Long idx) {

        QTodo qTodo = QTodo.todo;

        Todo todo = new Todo();
        todo.setIdx(idx);

        BooleanBuilder builder = new BooleanBuilder();
        builderCondition(builder, todo, qTodo);

        return jpaQueryFactory
                .select(qTodo)
                .from(qTodo)
                .where(builder)
                .fetch()
                .get(0);
    }

    private void builderCondition(BooleanBuilder builder, Todo todo, QTodo qTodo){

        if(!ObjectUtils.isEmpty(todo.getIdx())){
            if(todo.getIdx() != 0) {
                builder.and(qTodo.idx.eq(todo.getIdx()));
            }
        }
    }
}
