package com.boardsite.adm.boardsiteadm.repository.querydsl.travel;

import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyLikeOnlyDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface TravelAgencyLikeCustomRepository {

    PageImpl<TravelAgencyLikeOnlyDto> findByCustomTripUser_Id(Long id, Pageable pageable);

}
