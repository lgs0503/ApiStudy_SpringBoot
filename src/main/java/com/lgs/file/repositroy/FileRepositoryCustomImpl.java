package com.lgs.file.repositroy;

import com.lgs.file.entitiy.FileInfo;
import com.lgs.file.entitiy.QFileInfo;
import com.lgs.todo.entitiy.QTodo;
import com.lgs.todo.entitiy.Todo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;

public class FileRepositoryCustomImpl implements FileRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public FileRepositoryCustomImpl(EntityManager em) {
        jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public FileInfo search(Long idx) {

        QFileInfo qFileInfo = QFileInfo.fileInfo;

        FileInfo fileInfo = new FileInfo();
        fileInfo.setIdx(idx);

        BooleanBuilder builder = new BooleanBuilder();
        builderCondition(builder, fileInfo, qFileInfo);

        return jpaQueryFactory
                .select(qFileInfo)
                .from(qFileInfo)
                .where(builder)
                .fetch()
                .get(0);
    }

    private void builderCondition(BooleanBuilder builder, FileInfo fileInfo, QFileInfo qFileInfo){

        if(!ObjectUtils.isEmpty(fileInfo.getIdx())){
            builder.and(qFileInfo.idx.eq(fileInfo.getIdx()));
        }
    }
}
