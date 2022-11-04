package com.boardsite.adm.boardsiteadm.repository.querydsl.adm.tour;

import com.boardsite.adm.boardsiteadm.domain.tour.Tour;
import com.boardsite.adm.boardsiteadm.dto.tour.TourOnlyListDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdmTourCustomRepository {

    List<Tour> findTourRandomCount(int count);

    PageImpl<TourOnlyListDto> findCustomAll(Pageable pageable);

    PageImpl<TourOnlyListDto> findCustomByTitleContaining(String searchKeyWord ,Pageable pageable);

    PageImpl<TourOnlyListDto> findCustomByCityContaining(String searchKeyWord , Pageable pageable);

}
