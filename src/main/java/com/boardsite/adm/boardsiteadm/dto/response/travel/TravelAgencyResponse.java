package com.boardsite.adm.boardsiteadm.dto.response.travel;


import com.boardsite.adm.boardsiteadm.dto.travel.TravelAgencyDto;

public record TravelAgencyResponse(
        Long id,
        String name,
        String tel,
        String detail,
        String comment,
        Long fileId,
        String filePath,
        String address,
        boolean deleted
) {
    public static TravelAgencyResponse of(Long id,
                                          String name,
                                          String tel,
                                          String detail,
                                          String comment,
                                          Long fileId,
                                          String filePath,
                                          String address,
                                          boolean deleted) {
        return new TravelAgencyResponse(
                id,
                name,
                tel,
                detail,
                comment,
                fileId,
                filePath,
                address,
                deleted);
    }

    public static TravelAgencyResponse from(TravelAgencyDto dto){
        return new TravelAgencyResponse(
                dto.id(),
                dto.name(),
                dto.tel(),
                dto.detail(),
                dto.comment(),
                dto.fileId(),
                null,
                dto.address(),
                dto.deleted()
        );
    }

    public static TravelAgencyResponse from(TravelAgencyOnlyListDto dto){
        return new TravelAgencyResponse(
                dto.getId(),
                dto.getName(),
                dto.getTel(),
                dto.getDetail(),
                dto.getComment(),
                dto.getFileId(),
                dto.getFilePath(),
                dto.getAddress(),
                dto.isDeleted()
        );
    }

}

