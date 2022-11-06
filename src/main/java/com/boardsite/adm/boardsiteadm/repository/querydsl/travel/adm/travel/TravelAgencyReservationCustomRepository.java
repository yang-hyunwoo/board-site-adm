package com.boardsite.adm.boardsiteadm.repository.querydsl.travel.adm.travel;


import com.boardsite.adm.boardsiteadm.dto.response.adm.dashboard.TravelListCountDto;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyReservationOnlyListDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TravelAgencyReservationCustomRepository {

    List<TravelListCountDto> findTravelAgencyReservation(Long travelAgencyId , String auth);

    PageImpl<TravelAgencyReservationOnlyListDto> findCustomList(Long id, Pageable pageable);
}
