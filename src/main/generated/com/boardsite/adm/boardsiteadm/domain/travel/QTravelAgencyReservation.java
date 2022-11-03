package com.boardsite.adm.boardsiteadm.domain.travel;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTravelAgencyReservation is a Querydsl query type for TravelAgencyReservation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTravelAgencyReservation extends EntityPathBase<TravelAgencyReservation> {

    private static final long serialVersionUID = -1747918428L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTravelAgencyReservation travelAgencyReservation = new QTravelAgencyReservation("travelAgencyReservation");

    public final com.boardsite.adm.boardsiteadm.domain.QAuditingFields _super = new com.boardsite.adm.boardsiteadm.domain.QAuditingFields(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath failReason = createString("failReason");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath impUid = createString("impUid");

    public final StringPath merchantUid = createString("merchantUid");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final NumberPath<Integer> paid = createNumber("paid", Integer.class);

    public final StringPath payEmail = createString("payEmail");

    public final StringPath payName = createString("payName");

    public final NumberPath<Integer> personCount = createNumber("personCount", Integer.class);

    public final BooleanPath qrChk = createBoolean("qrChk");

    public final NumberPath<Long> qrCodeId = createNumber("qrCodeId", Long.class);

    public final NumberPath<Integer> realPaid = createNumber("realPaid", Integer.class);

    public final StringPath reFundReason = createString("reFundReason");

    public final NumberPath<Integer> salePercent = createNumber("salePercent", Integer.class);

    public final QTravelAgency travelAgency;

    public final QTravelAgencyList travelAgencyList;

    public final com.boardsite.adm.boardsiteadm.domain.user.QTripUser tripUser;

    public QTravelAgencyReservation(String variable) {
        this(TravelAgencyReservation.class, forVariable(variable), INITS);
    }

    public QTravelAgencyReservation(Path<? extends TravelAgencyReservation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTravelAgencyReservation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTravelAgencyReservation(PathMetadata metadata, PathInits inits) {
        this(TravelAgencyReservation.class, metadata, inits);
    }

    public QTravelAgencyReservation(Class<? extends TravelAgencyReservation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.travelAgency = inits.isInitialized("travelAgency") ? new QTravelAgency(forProperty("travelAgency")) : null;
        this.travelAgencyList = inits.isInitialized("travelAgencyList") ? new QTravelAgencyList(forProperty("travelAgencyList"), inits.get("travelAgencyList")) : null;
        this.tripUser = inits.isInitialized("tripUser") ? new com.boardsite.adm.boardsiteadm.domain.user.QTripUser(forProperty("tripUser")) : null;
    }

}

