package com.boardsite.adm.boardsiteadm.domain.tour;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTourComment is a Querydsl query type for TourComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTourComment extends EntityPathBase<TourComment> {

    private static final long serialVersionUID = -48703620L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTourComment tourComment = new QTourComment("tourComment");

    public final com.boardsite.adm.boardsiteadm.domain.QAuditingFields _super = new com.boardsite.adm.boardsiteadm.domain.QAuditingFields(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final BooleanPath deleted = createBoolean("deleted");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final QTour tour;

    public final com.boardsite.adm.boardsiteadm.domain.user.QTripUser tripUser;

    public QTourComment(String variable) {
        this(TourComment.class, forVariable(variable), INITS);
    }

    public QTourComment(Path<? extends TourComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTourComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTourComment(PathMetadata metadata, PathInits inits) {
        this(TourComment.class, metadata, inits);
    }

    public QTourComment(Class<? extends TourComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tour = inits.isInitialized("tour") ? new QTour(forProperty("tour"), inits.get("tour")) : null;
        this.tripUser = inits.isInitialized("tripUser") ? new com.boardsite.adm.boardsiteadm.domain.user.QTripUser(forProperty("tripUser")) : null;
    }

}

