package com.boardsite.adm.boardsiteadm.repository.adm.travel;

import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;
import com.boardsite.adm.boardsiteadm.repository.querydsl.travel.adm.travel.AdmTravelAgencyCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmTravelAgencyRepository extends JpaRepository<TravelAgency, Long> , AdmTravelAgencyCustomRepository {


    Page<TravelAgency> findByNameContaining(String TravelAgencyName , Pageable pageable);

    Page<TravelAgency> findByIdAndNameContaining(Long travelAgencyId , String TravelAgencyName , Pageable pageable);


    Optional<TravelAgency> findByIdAndDeleted(Long travelAgencyId , boolean deleted);

    Page<TravelAgency> findAllById(Long id , Pageable pageable);


    Optional<TravelAgency> findByName(String name);





}
