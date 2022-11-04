package com.boardsite.adm.boardsiteadm.repository.querydsl.travel;


import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyListOnlyListDto;

import java.util.List;

public interface TravelAgencyListCustomRepository {

    List<TravelAgencyListOnlyListDto> findByDeletedAndSortIsNotNullOrderBySort();
}
