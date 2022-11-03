package com.boardsite.adm.boardsiteadm.repository.adm.tour;

import com.boardsite.adm.boardsiteadm.domain.tour.Tour;
import com.boardsite.adm.boardsiteadm.repository.querydsl.tour.TourCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface AdmTourRepository extends
        JpaRepository<Tour, Long>,
        QuerydslPredicateExecutor<Tour>,
        TourCustomRepository
{

    Page<Tour> findByTitleContaining(String title , Pageable pageable);

    Page<Tour> findByCityContaining(String city , Pageable pageable);

    Optional<Tour> findByIdAndDeleted(Long tourId , boolean deleted);


}