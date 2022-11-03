package com.boardsite.adm.boardsiteadm.domain.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAttachFile is a Querydsl query type for AttachFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttachFile extends EntityPathBase<AttachFile> {

    private static final long serialVersionUID = 293817721L;

    public static final QAttachFile attachFile = new QAttachFile("attachFile");

    public final com.boardsite.adm.boardsiteadm.domain.QAuditingFields _super = new com.boardsite.adm.boardsiteadm.domain.QAuditingFields(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final BooleanPath deleted = createBoolean("deleted");

    public final NumberPath<Integer> fileChildId = createNumber("fileChildId", Integer.class);

    public final NumberPath<Long> fileId = createNumber("fileId", Long.class);

    public final StringPath fileName = createString("fileName");

    public final StringPath filePath = createString("filePath");

    public final NumberPath<Long> fileSize = createNumber("fileSize", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath originFileName = createString("originFileName");

    public final StringPath thumbFilePath = createString("thumbFilePath");

    public QAttachFile(String variable) {
        super(AttachFile.class, forVariable(variable));
    }

    public QAttachFile(Path<? extends AttachFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttachFile(PathMetadata metadata) {
        super(AttachFile.class, metadata);
    }

}

