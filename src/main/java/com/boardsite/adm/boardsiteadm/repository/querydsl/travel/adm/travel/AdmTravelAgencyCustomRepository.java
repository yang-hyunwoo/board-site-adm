package com.boardsite.adm.boardsiteadm.repository.querydsl.travel.adm.travel;

import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyOnlyListDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AdmTravelAgencyCustomRepository {

    PageImpl<TravelAgencyOnlyListDto> findCustomAll(Pageable pageable);

    PageImpl<TravelAgencyOnlyListDto> findCustomByNameContaining(String travelAgencyName ,Pageable pageable);

    PageImpl<TravelAgencyOnlyListDto> findCustomAllDivide(Long travelId ,Pageable pageable);

    PageImpl<TravelAgencyOnlyListDto> findCustomByNameContainingDivide(Long travelId , String travelAgencyName ,Pageable pageable);

    Optional<TravelAgencyOnlyListDto> findCustomDetail(Long travelAgencyId);


}
