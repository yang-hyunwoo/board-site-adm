package com.boardsite.adm.boardsiteadm.service.travel;

import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;
import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgencyList;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyOnlyListDto;
import com.boardsite.adm.boardsiteadm.dto.travel.TravelAgencyDto;
import com.boardsite.adm.boardsiteadm.dto.travel.TravelAgencyWithTravelAgencyListDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.travel.TravelAgencyListRepository;
import com.boardsite.adm.boardsiteadm.repository.travel.TravelAgencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TravelAgencyService {

    private final TravelAgencyRepository travelAgencyRepository;

    private final TravelAgencyListRepository travelAgencyListRepository;

    @Transactional(readOnly = true)
    public Page<TravelAgencyOnlyListDto> travelAgencyList(String travelAgencyName , Pageable pageable) {

        if (travelAgencyName == null || travelAgencyName.isBlank()) {
            return travelAgencyRepository.findCustomAllByDeleted(false,pageable);
        }
        return travelAgencyRepository.findCustomByNameContainingAndDeleted(travelAgencyName , false,pageable);
    }

    @Transactional(readOnly = true)
    public TravelAgencyDto travelAgencyDetail(Long travelAgencyId) {
        return travelAgencyRepository.findByIdAndDeleted(travelAgencyId,false).map(TravelAgencyDto::from).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public TravelAgencyWithTravelAgencyListDto travelAgencyWithTravelAgencyList(Long travelAgencyId) {
        TravelAgency travelAgency = travelAgencyRepository.findByIdAndDeleted(travelAgencyId,false).orElseThrow();
        List<TravelAgencyList> travelAgencyList = travelAgencyListRepository.findByTravelAgencyIdAndDeletedOrderByTitleAsc(travelAgencyId,false);

        travelAgency.getTravelAgencyLists().clear();
        travelAgency.getTravelAgencyLists().addAll(travelAgencyList);

        Optional<TravelAgency> optionalTravelAgency = Optional.of(travelAgency);

        return optionalTravelAgency.map(TravelAgencyWithTravelAgencyListDto::from).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public List<TravelAgencyOnlyListDto> travelAgencyRandomThree() {
        int count = 3;

        return travelAgencyRepository.findTravelAgencyRandomCount(count);
    }
}
