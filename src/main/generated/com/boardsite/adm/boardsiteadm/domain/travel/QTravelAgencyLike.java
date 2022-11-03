package com.boardsite.adm.boardsiteadm.domain.travel;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTravelAgencyLike is a Querydsl query type for TravelAgencyLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTravelAgencyLike extends EntityPathBase<TravelAgencyLike> {

    private static final long serialVersionUID = 1636725951L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTravelAgencyLike travelAgencyLike = new QTravelAgencyLike("travelAgencyLike");

    public final com.boardsite.adm.boardsiteadm.domain.QAuditingFields _super = new com.boardsite.adm.boardsiteadm.domain.QAuditingFields(this);

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

    public final QTravelAgencyList travelAgencyList;

    public final com.boardsite.adm.boardsiteadm.domain.user.QTripUser tripUser;

    public QTravelAgencyLike(String variable) {
        this(TravelAgencyLike.class, forVariable(variable), INITS);
    }

    public QTravelAgencyLike(Path<? extends TravelAgencyLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTravelAgencyLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTravelAgencyLike(PathMetadata metadata, PathInits inits) {
        this(TravelAgencyLike.class, metadata, inits);
    }

    public QTravelAgencyLike(Class<? extends TravelAgencyLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.travelAgencyList = inits.isInitialized("travelAgencyList") ? new QTravelAgencyList(forProperty("travelAgencyList"), inits.get("travelAgencyList")) : null;
        this.tripUser = inits.isInitialized("tripUser") ? new com.boardsite.adm.boardsiteadm.domain.user.QTripUser(forProperty("tripUser")) : null;
    }

}

