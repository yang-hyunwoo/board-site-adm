package com.boardsite.adm.boardsiteadm.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTripUserHistory is a Querydsl query type for TripUserHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTripUserHistory extends EntityPathBase<TripUserHistory> {

    private static final long serialVersionUID = 1928321132L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTripUserHistory tripUserHistory = new QTripUserHistory("tripUserHistory");

    public final com.boardsite.adm.boardsiteadm.domain.QAuditingFields _super = new com.boardsite.adm.boardsiteadm.domain.QAuditingFields(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath email = createString("email");

    public final EnumPath<com.boardsite.adm.boardsiteadm.domain.constant.Gender> gender = createEnum("gender", com.boardsite.adm.boardsiteadm.domain.constant.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath name = createString("name");

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final QTripUser tripUser;

    public QTripUserHistory(String variable) {
        this(TripUserHistory.class, forVariable(variable), INITS);
    }

    public QTripUserHistory(Path<? extends TripUserHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTripUserHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTripUserHistory(PathMetadata metadata, PathInits inits) {
        this(TripUserHistory.class, metadata, inits);
    }

    public QTripUserHistory(Class<? extends TripUserHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tripUser = inits.isInitialized("tripUser") ? new QTripUser(forProperty("tripUser")) : null;
    }

}

