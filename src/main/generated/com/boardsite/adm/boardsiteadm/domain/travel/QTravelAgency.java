package com.boardsite.adm.boardsiteadm.domain.travel;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTravelAgency is a Querydsl query type for TravelAgency
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTravelAgency extends EntityPathBase<TravelAgency> {

    private static final long serialVersionUID = -1626598136L;

    public static final QTravelAgency travelAgency = new QTravelAgency("travelAgency");

    public final com.boardsite.adm.boardsiteadm.domain.QAuditingFields _super = new com.boardsite.adm.boardsiteadm.domain.QAuditingFields(this);

    public final StringPath address = createString("address");

    public final StringPath comment = createString("comment");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath detail = createString("detail");

    public final NumberPath<Long> fileId = createNumber("fileId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath name = createString("name");

    public final StringPath tel = createString("tel");

    public final ListPath<TravelAgencyList, QTravelAgencyList> travelAgencyLists = this.<TravelAgencyList, QTravelAgencyList>createList("travelAgencyLists", TravelAgencyList.class, QTravelAgencyList.class, PathInits.DIRECT2);

    public final SetPath<TravelAgencyReservation, QTravelAgencyReservation> travelAgencyReservationLists = this.<TravelAgencyReservation, QTravelAgencyReservation>createSet("travelAgencyReservationLists", TravelAgencyReservation.class, QTravelAgencyReservation.class, PathInits.DIRECT2);

    public QTravelAgency(String variable) {
        super(TravelAgency.class, forVariable(variable));
    }

    public QTravelAgency(Path<? extends TravelAgency> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTravelAgency(PathMetadata metadata) {
        super(TravelAgency.class, metadata);
    }

}

