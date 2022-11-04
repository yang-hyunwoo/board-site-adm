package com.boardsite.adm.boardsiteadm.repository.querydsl.travel;

import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyOnlyListDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TravelAgencyCustomRepository {

    List<TravelAgencyOnlyListDto> findTravelAgencyRandomCount(int count);

    PageImpl<TravelAgencyOnlyListDto> findCustomAllByDeleted(boolean deleted , Pageable pageable);

    PageImpl<TravelAgencyOnlyListDto> findCustomByNameContainingAndDeleted(String travelAgencyName , boolean deleted , Pageable pageable);



}
