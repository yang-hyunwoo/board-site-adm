package com.boardsite.adm.boardsiteadm.repository.querydsl.travel;

import com.boardsite.adm.boardsiteadm.domain.common.QAttachFile;
import com.boardsite.adm.boardsiteadm.domain.travel.QTravelAgencyList;
import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyListOnlyListDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TravelAgencyListCustomRepositoryImpl extends QuerydslRepositorySupport implements TravelAgencyListCustomRepository {
    @PersistenceContext
    EntityManager em;

    private final JPAQueryFactory queryFactory;

    public TravelAgencyListCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        super(TravelAgency.class);
        this.queryFactory = queryFactory;
    }

    QTravelAgencyList travelAgencyList = QTravelAgencyList.travelAgencyList;
    QAttachFile attachFile = QAttachFile.attachFile;


    @Override
    public List<TravelAgencyListOnlyListDto> findByDeletedAndSortIsNotNullOrderBySort() {
        return queryFactory.select(Projections.bean(TravelAgencyListOnlyListDto.class,
                travelAgencyList.id.as("id"),
                travelAgencyList.travelAgency.id.as("travel_agency_id"),
                travelAgencyList.travelAgency.name.as("travel_name"),
                travelAgencyList.city.as("city"),
                travelAgencyList.content.as("content"),
                travelAgencyList.realPaid.as("real_paid"),
                travelAgencyList.salePaid.as("sale_paid"),
                travelAgencyList.salePercent.as("sale_percent"),
                attachFile.filePath.as("filePath"),
                travelAgencyList.sort.as("sort"),
                travelAgencyList.title.as("title")))
        .from(travelAgencyList)
                .leftJoin(attachFile)
                .on(travelAgencyList.thumnbnailFileId.eq(attachFile.fileId))
                .where(travelAgencyList.deleted.eq(false),
                        travelAgencyList.sort.isNotNull())
                .orderBy(travelAgencyList.sort.asc())
                .fetch();


    }
}
