package com.boardsite.adm.boardsiteadm.dto.request.adm.travel;


public record QrcodeUserUpdateRequest(
        Long id,
        Long userId,
        int count,
        Long travelAgencyListId
) {
    public static QrcodeUserUpdateRequest of(Long id,
                                   Long userId,
                                             int count,
                                             Long travelAgencyListId) {
        return new QrcodeUserUpdateRequest(id ,
                userId,
                count,
                travelAgencyListId);
    }

}
