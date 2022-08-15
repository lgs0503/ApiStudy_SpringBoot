package com.lgs.todo.repository;

import com.lgs.todo.entitiy.QTodo;
import com.lgs.todo.entitiy.Todo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

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

    private void builderCondition(BooleanBuilder builder, Todo todo, QTodo qTodo){
        /* 조건 조회 */
/*        if(!ObjectUtils.isEmpty(banner.getUseYn())) {
            builder.and(qBanner.useYn.eq(banner.getUseYn()));
        }
        if(!ObjectUtils.isEmpty(banner.getBannerName())) {
            builder.and(qBanner.bannerName.eq(banner.getBannerName()));
        }
        if(!ObjectUtils.isEmpty(banner.getBannerType())) {
            builder.and(qBanner.bannerType.eq(banner.getBannerType()));
        }*/
    }
}
