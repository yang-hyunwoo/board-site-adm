package com.boardsite.adm.boardsiteadm.repository.querydsl.travel.adm.travel;


import com.boardsite.adm.boardsiteadm.dto.response.adm.dashboard.TravelListCountDto;

import java.util.List;

public interface TravelAgencyReservationCustomRepository {

    List<TravelListCountDto> findTravelAgencyReservation(Long travelAgencyId , String auth);
}
