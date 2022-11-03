package com.boardsite.adm.boardsiteadm.domain.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSequenceId is a Querydsl query type for SequenceId
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSequenceId extends EntityPathBase<SequenceId> {

    private static final long serialVersionUID = 2093954260L;

    public static final QSequenceId sequenceId = new QSequenceId("sequenceId");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QSequenceId(String variable) {
        super(SequenceId.class, forVariable(variable));
    }

    public QSequenceId(Path<? extends SequenceId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSequenceId(PathMetadata metadata) {
        super(SequenceId.class, metadata);
    }

}

