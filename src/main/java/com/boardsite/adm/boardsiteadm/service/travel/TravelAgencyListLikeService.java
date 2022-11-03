package com.boardsite.adm.boardsiteadm.service.travel;

import com.boardsite.adm.boardsiteadm.dto.travel.TravelAgencyLikeDto;
import com.boardsite.adm.boardsiteadm.repository.travel.TravelAgencyListLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TravelAgencyListLikeService {

    private final TravelAgencyListLikeRepository travelAgencyListLikeRepository;

    @Transactional(readOnly = true)
    public Page<TravelAgencyLikeDto> travelAgencyLikeList(Long id , Pageable pageable) {
       var travelAgencyLikeDto =  travelAgencyListLikeRepository.findByTripUser_Id(id, pageable).map(TravelAgencyLikeDto::from);;

       return travelAgencyLikeDto;
    }
}
