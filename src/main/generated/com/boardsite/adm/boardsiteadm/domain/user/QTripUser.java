package com.boardsite.adm.boardsiteadm.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTripUser is a Querydsl query type for TripUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTripUser extends EntityPathBase<TripUser> {

    private static final long serialVersionUID = 959163144L;

    public static final QTripUser tripUser = new QTripUser("tripUser");

    public final com.boardsite.adm.boardsiteadm.domain.QAuditingFields _super = new com.boardsite.adm.boardsiteadm.domain.QAuditingFields(this);

    public final BooleanPath authChk = createBoolean("authChk");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath email = createString("email");

    public final BooleanPath emailAuth = createBoolean("emailAuth");

    public final EnumPath<com.boardsite.adm.boardsiteadm.domain.constant.Gender> gender = createEnum("gender", com.boardsite.adm.boardsiteadm.domain.constant.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath loginType = createString("loginType");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath name = createString("name");

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final NumberPath<Long> profileId = createNumber("profileId", Long.class);

    public final StringPath refreshToken = createString("refreshToken");

    public final StringPath role = createString("role");

    public final NumberPath<Long> travelAgencyId = createNumber("travelAgencyId", Long.class);

    public QTripUser(String variable) {
        super(TripUser.class, forVariable(variable));
    }

    public QTripUser(Path<? extends TripUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTripUser(PathMetadata metadata) {
        super(TripUser.class, metadata);
    }

}

