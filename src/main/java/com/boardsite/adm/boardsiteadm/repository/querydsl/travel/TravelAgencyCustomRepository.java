package com.boardsite.adm.boardsiteadm.repository.querydsl.travel;

import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyOnlyListDto;

import java.util.List;

public interface TravelAgencyCustomRepository {

    List<TravelAgencyOnlyListDto> findTravelAgencyRandomCount(int count);;
}
