package com.boardsite.adm.boardsiteadm.domain.chat;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChatRoomPerson is a Querydsl query type for ChatRoomPerson
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChatRoomPerson extends EntityPathBase<ChatRoomPerson> {

    private static final long serialVersionUID = -1581122093L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChatRoomPerson chatRoomPerson = new QChatRoomPerson("chatRoomPerson");

    public final com.boardsite.adm.boardsiteadm.domain.QAuditingFields _super = new com.boardsite.adm.boardsiteadm.domain.QAuditingFields(this);

    public final QChatRoom chatRoom;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final com.boardsite.adm.boardsiteadm.domain.user.QTripUser tripUser;

    public QChatRoomPerson(String variable) {
        this(ChatRoomPerson.class, forVariable(variable), INITS);
    }

    public QChatRoomPerson(Path<? extends ChatRoomPerson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChatRoomPerson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChatRoomPerson(PathMetadata metadata, PathInits inits) {
        this(ChatRoomPerson.class, metadata, inits);
    }

    public QChatRoomPerson(Class<? extends ChatRoomPerson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chatRoom = inits.isInitialized("chatRoom") ? new QChatRoom(forProperty("chatRoom")) : null;
        this.tripUser = inits.isInitialized("tripUser") ? new com.boardsite.adm.boardsiteadm.domain.user.QTripUser(forProperty("tripUser")) : null;
    }

}

