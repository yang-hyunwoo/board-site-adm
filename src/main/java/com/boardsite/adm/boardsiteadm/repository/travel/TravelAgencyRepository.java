package com.boardsite.adm.boardsiteadm.repository.travel;

import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;
import com.boardsite.adm.boardsiteadm.repository.querydsl.travel.TravelAgencyCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TravelAgencyRepository extends JpaRepository<TravelAgency, Long> ,
        TravelAgencyCustomRepository {

    Page<TravelAgency> findByNameContainingAndDeleted(String TravelAgencyName , Pageable pageable,boolean deleted);
    Page<TravelAgency> findAllByDeleted(Pageable pageable, boolean deleted);
    Optional<TravelAgency> findByIdAndDeleted(Long travelAgencyId , boolean deleted);

    List<TravelAgency> findAllByDeleted(boolean deleted);
}
