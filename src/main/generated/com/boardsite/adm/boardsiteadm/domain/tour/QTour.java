package com.boardsite.adm.boardsiteadm.domain.tour;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTour is a Querydsl query type for Tour
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTour extends EntityPathBase<Tour> {

    private static final long serialVersionUID = 1200744803L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTour tour = new QTour("tour");

    public final com.boardsite.adm.boardsiteadm.domain.QAuditingFields _super = new com.boardsite.adm.boardsiteadm.domain.QAuditingFields(this);

    public final StringPath city = createString("city");

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

    public final NumberPath<Integer> readCount = createNumber("readCount", Integer.class);

    public final NumberPath<Long> thumbnailId = createNumber("thumbnailId", Long.class);

    public final StringPath title = createString("title");

    public final SetPath<TourComment, QTourComment> tourComments = this.<TourComment, QTourComment>createSet("tourComments", TourComment.class, QTourComment.class, PathInits.DIRECT2);

    public final com.boardsite.adm.boardsiteadm.domain.user.QTripUser tripUser;

    public QTour(String variable) {
        this(Tour.class, forVariable(variable), INITS);
    }

    public QTour(Path<? extends Tour> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTour(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTour(PathMetadata metadata, PathInits inits) {
        this(Tour.class, metadata, inits);
    }

    public QTour(Class<? extends Tour> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tripUser = inits.isInitialized("tripUser") ? new com.boardsite.adm.boardsiteadm.domain.user.QTripUser(forProperty("tripUser")) : null;
    }

}

