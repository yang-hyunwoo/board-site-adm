package com.boardsite.adm.boardsiteadm.repository.querydsl.travel;

import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;

import java.util.List;

public interface TravelAgencyCustomRepository {

    List<TravelAgency> findTravelAgencyRandomCount(int count);
}
