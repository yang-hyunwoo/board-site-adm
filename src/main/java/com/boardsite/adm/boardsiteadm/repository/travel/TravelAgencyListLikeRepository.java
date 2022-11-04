package com.boardsite.adm.boardsiteadm.repository.travel;

import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgencyLike;
import com.boardsite.adm.boardsiteadm.repository.querydsl.travel.TravelAgencyLikeCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TravelAgencyListLikeRepository extends JpaRepository<TravelAgencyLike , Long> , TravelAgencyLikeCustomRepository {

    Optional<TravelAgencyLike> findByTravelAgencyList_IdAndTripUser_Id(Long travel_agency_id, Long trip_user_id);

    Page<TravelAgencyLike> findByTripUser_Id(Long id, Pageable pageable);
}