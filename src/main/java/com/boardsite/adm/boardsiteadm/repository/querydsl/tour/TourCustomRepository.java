package com.boardsite.adm.boardsiteadm.repository.querydsl.tour;

import com.boardsite.adm.boardsiteadm.domain.tour.Tour;

import java.util.List;

public interface TourCustomRepository {

    List<Tour> findTourRandomCount(int count);
}
