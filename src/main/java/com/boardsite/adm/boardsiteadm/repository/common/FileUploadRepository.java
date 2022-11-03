package com.boardsite.adm.boardsiteadm.repository.common;


import com.boardsite.adm.boardsiteadm.domain.common.AttachFile;
import com.boardsite.adm.boardsiteadm.domain.common.AttachFileId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<AttachFile, AttachFileId> {
}
