package com.boardsite.adm.boardsiteadm.repository.querydsl.travel;


import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyListOnlyListDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TravelAgencyListCustomRepository {

    List<TravelAgencyListOnlyListDto> findByDeletedAndSortIsNotNullOrderBySort();

    PageImpl<TravelAgencyListOnlyListDto> findByCustomTravelAgency_IdAndDeleted(Long id, boolean deleted, Pageable pageable);

    PageImpl<TravelAgencyListOnlyListDto> findCustomByAllDeleted( boolean deleted, Pageable pageable);

    PageImpl<TravelAgencyListOnlyListDto> findCustomByTitleContaingAndDeleted(String travelAgencyTitleName , boolean deleted, Pageable pageable);


}
