package com.boardsite.adm.boardsiteadm.repository.querydsl.tour;

import com.boardsite.adm.boardsiteadm.domain.tour.Tour;
import com.boardsite.adm.boardsiteadm.dto.tour.TourOnlyListDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TourCustomRepository {

    List<TourOnlyListDto> findTourRandomCount(int count);
    PageImpl<TourOnlyListDto> findCustomAllByDeleted(boolean deleted , Pageable pageable);

    PageImpl<TourOnlyListDto> findCustomByTitleContainingAndDeleted(String searchKeyWord , boolean deleted , Pageable pageable);

    PageImpl<TourOnlyListDto> findCustomByCityContainingAndDeleted(String searchKeyWord , boolean deleted , Pageable pageable);

}
