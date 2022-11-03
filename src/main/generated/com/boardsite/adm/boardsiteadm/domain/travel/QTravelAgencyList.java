package com.boardsite.adm.boardsiteadm.domain.travel;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTravelAgencyList is a Querydsl query type for TravelAgencyList
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTravelAgencyList extends EntityPathBase<TravelAgencyList> {

    private static final long serialVersionUID = 1636726214L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTravelAgencyList travelAgencyList = new QTravelAgencyList("travelAgencyList");

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

    public final NumberPath<Integer> personCount = createNumber("personCount", Integer.class);

    public final NumberPath<Integer> personMaxCount = createNumber("personMaxCount", Integer.class);

    public final NumberPath<Integer> readCount = createNumber("readCount", Integer.class);

    public final NumberPath<Integer> realPaid = createNumber("realPaid", Integer.class);

    public final NumberPath<Integer> salePaid = createNumber("salePaid", Integer.class);

    public final NumberPath<Integer> salePercent = createNumber("salePercent", Integer.class);

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    public final NumberPath<Long> thumnbnailFileId = createNumber("thumnbnailFileId", Long.class);

    public final StringPath title = createString("title");

    public final QTravelAgency travelAgency;

    public final SetPath<TravelAgencyLike, QTravelAgencyLike> travelAgencyLikes = this.<TravelAgencyLike, QTravelAgencyLike>createSet("travelAgencyLikes", TravelAgencyLike.class, QTravelAgencyLike.class, PathInits.DIRECT2);

    public final SetPath<TravelAgencyReservation, QTravelAgencyReservation> travelAgencyReservationLists = this.<TravelAgencyReservation, QTravelAgencyReservation>createSet("travelAgencyReservationLists", TravelAgencyReservation.class, QTravelAgencyReservation.class, PathInits.DIRECT2);

    public final StringPath travelEndAt = createString("travelEndAt");

    public final StringPath travelRealTripAt = createString("travelRealTripAt");

    public final StringPath travelStartAt = createString("travelStartAt");

    public QTravelAgencyList(String variable) {
        this(TravelAgencyList.class, forVariable(variable), INITS);
    }

    public QTravelAgencyList(Path<? extends TravelAgencyList> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTravelAgencyList(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTravelAgencyList(PathMetadata metadata, PathInits inits) {
        this(TravelAgencyList.class, metadata, inits);
    }

    public QTravelAgencyList(Class<? extends TravelAgencyList> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.travelAgency = inits.isInitialized("travelAgency") ? new QTravelAgency(forProperty("travelAgency")) : null;
    }

}

