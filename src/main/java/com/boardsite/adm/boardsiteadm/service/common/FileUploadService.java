package com.boardsite.adm.boardsiteadm.service.common;

import com.boardsite.adm.boardsiteadm.domain.common.AttachFileId;
import com.boardsite.adm.boardsiteadm.dto.common.AttachFileDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.common.FileUploadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final FileUploadRepository fileUploadRepository;


    @Transactional
    public void saveImage(List<AttachFileDto> attachFileDtos) {
        var saveImageList= attachFileDtos.stream().map(AttachFileDto::toEntity).collect(Collectors.toList());
        fileUploadRepository.saveAll(saveImageList);
    }

    @Transactional(readOnly = true)
    public String findFilePath(Long fileId,int fileChildId) {
        var findfilePath = fileUploadRepository.findById(new AttachFileId(fileId,fileChildId)).orElseThrow(()->new BoardSiteException(ErrorCode.FILE_NOT_FOUND));
        return findfilePath.getFilePath();
    }

    @Transactional(readOnly = true)
    public String findThumbFilePath(Long fileId,int fileChildId) {
        var findfilePath = fileUploadRepository.findById(new AttachFileId(fileId,fileChildId)).orElseThrow(()->new BoardSiteException(ErrorCode.FILE_NOT_FOUND));
        return findfilePath.getThumbFilePath();
    }
}
