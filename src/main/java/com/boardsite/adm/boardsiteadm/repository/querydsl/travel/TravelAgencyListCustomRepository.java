package com.boardsite.adm.boardsiteadm.repository.querydsl.travel;


import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyListOnlyListDto;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TravelAgencyListCustomRepository {

    List<TravelAgencyListOnlyListDto> findByDeletedAndSortIsNotNullOrderBySort();

    PageImpl<TravelAgencyListOnlyListDto> findByCustomTravelAgency_IdAndDeleted(Long id, boolean deleted, Pageable pageable);

    PageImpl<TravelAgencyListOnlyListDto> findCustomByAllDeleted(boolean deleted, TripUserPrincipal tripUserPrincipal, Pageable pageable);

    PageImpl<TravelAgencyListOnlyListDto> findCustomByTitleContaingAndDeleted(String travelAgencyTitleName ,TripUserPrincipal tripUserPrincipal, boolean deleted, Pageable pageable);

    Optional<TravelAgencyListOnlyListDto> findCustomByDetail(Long ListId, boolean deleted);

}
