package com.boardsite.adm.boardsiteadm.domain.chat;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChatRoomMessage is a Querydsl query type for ChatRoomMessage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChatRoomMessage extends EntityPathBase<ChatRoomMessage> {

    private static final long serialVersionUID = -136778423L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChatRoomMessage chatRoomMessage = new QChatRoomMessage("chatRoomMessage");

    public final com.boardsite.adm.boardsiteadm.domain.QAuditingFields _super = new com.boardsite.adm.boardsiteadm.domain.QAuditingFields(this);

    public final QChatRoom chatRoom;

    public final StringPath content = createString("content");

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

    public QChatRoomMessage(String variable) {
        this(ChatRoomMessage.class, forVariable(variable), INITS);
    }

    public QChatRoomMessage(Path<? extends ChatRoomMessage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChatRoomMessage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChatRoomMessage(PathMetadata metadata, PathInits inits) {
        this(ChatRoomMessage.class, metadata, inits);
    }

    public QChatRoomMessage(Class<? extends ChatRoomMessage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chatRoom = inits.isInitialized("chatRoom") ? new QChatRoom(forProperty("chatRoom")) : null;
        this.tripUser = inits.isInitialized("tripUser") ? new com.boardsite.adm.boardsiteadm.domain.user.QTripUser(forProperty("tripUser")) : null;
    }

}

