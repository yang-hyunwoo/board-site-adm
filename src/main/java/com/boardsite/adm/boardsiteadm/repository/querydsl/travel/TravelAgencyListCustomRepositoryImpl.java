package com.boardsite.adm.boardsiteadm.repository.querydsl.travel;

import com.boardsite.adm.boardsiteadm.domain.common.QAttachFile;
import com.boardsite.adm.boardsiteadm.domain.travel.QTravelAgencyList;
import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyListOnlyListDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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

    @Override
    public PageImpl<TravelAgencyListOnlyListDto> findByCustomTravelAgency_IdAndDeleted(Long id,
                                                                                       boolean deleted,
                                                                                       Pageable pageable) {
        var travelAgencyListPage =  queryFactory.select(Projections.bean(TravelAgencyListOnlyListDto.class,
                        travelAgencyList.id.as("id"),
                        travelAgencyList.travelAgency.id.as("travel_agency_id"),
                        travelAgencyList.travelAgency.name.as("travel_name"),
                        travelAgencyList.city.as("city"),
                        travelAgencyList.readCount.as("read_count"),
                        travelAgencyList.content.as("content"),
                        travelAgencyList.realPaid.as("real_paid"),
                        travelAgencyList.salePaid.as("sale_paid"),
                        travelAgencyList.salePercent.as("sale_percent"),
                        attachFile.filePath.as("filePath"),
                        travelAgencyList.sort.as("sort"),
                        travelAgencyList.travelStartAt.as("travel_start_at"),
                        travelAgencyList.travelEndAt.as("travel_end_at"),
                        travelAgencyList.title.as("title")))
                .from(travelAgencyList)
                .leftJoin(attachFile)
                .on(travelAgencyList.thumnbnailFileId.eq(attachFile.fileId))
                .where(travelAgencyList.travelAgency.id.eq(id),
                        travelAgencyList.deleted.eq(false))
                .orderBy(travelAgencyList.sort.asc())
                .fetch();
        return new PageImpl<>(travelAgencyListPage, pageable, travelAgencyListPage.size());
    }

    @Override
    public PageImpl<TravelAgencyListOnlyListDto> findCustomByAllDeleted(boolean deleted, Pageable pageable) {
        var travelAgencyListPage =  queryFactory.select(Projections.bean(TravelAgencyListOnlyListDto.class,
                        travelAgencyList.id.as("id"),
                        travelAgencyList.travelAgency.id.as("travel_agency_id"),
                        travelAgencyList.travelAgency.name.as("travel_name"),
                        travelAgencyList.city.as("city"),
                        travelAgencyList.readCount.as("read_count"),
                        travelAgencyList.content.as("content"),
                        travelAgencyList.realPaid.as("real_paid"),
                        travelAgencyList.salePaid.as("sale_paid"),
                        travelAgencyList.salePercent.as("sale_percent"),
                        attachFile.filePath.as("filePath"),
                        travelAgencyList.sort.as("sort"),
                        travelAgencyList.travelStartAt.as("travel_start_at"),
                        travelAgencyList.travelEndAt.as("travel_end_at"),
                        travelAgencyList.title.as("title")))
                .from(travelAgencyList)
                .leftJoin(attachFile)
                .on(travelAgencyList.thumnbnailFileId.eq(attachFile.fileId))
                .where(travelAgencyList.deleted.eq(false))
                .orderBy(travelAgencyList.sort.asc())
                .fetch();
        return new PageImpl<>(travelAgencyListPage, pageable, travelAgencyListPage.size());
    }

    @Override
    public PageImpl<TravelAgencyListOnlyListDto> findCustomByTitleContaingAndDeleted(String travelAgencyTitleName, boolean deleted, Pageable pageable) {
        var travelAgencyListPage =  queryFactory.select(Projections.bean(TravelAgencyListOnlyListDto.class,
                        travelAgencyList.id.as("id"),
                        travelAgencyList.travelAgency.id.as("travel_agency_id"),
                        travelAgencyList.travelAgency.name.as("travel_name"),
                        travelAgencyList.city.as("city"),
                        travelAgencyList.readCount.as("read_count"),
                        travelAgencyList.content.as("content"),
                        travelAgencyList.realPaid.as("real_paid"),
                        travelAgencyList.salePaid.as("sale_paid"),
                        travelAgencyList.salePercent.as("sale_percent"),
                        attachFile.filePath.as("filePath"),
                        travelAgencyList.sort.as("sort"),
                        travelAgencyList.travelStartAt.as("travel_start_at"),
                        travelAgencyList.travelEndAt.as("travel_end_at"),
                        travelAgencyList.title.as("title")))
                .from(travelAgencyList)
                .leftJoin(attachFile)
                .on(travelAgencyList.thumnbnailFileId.eq(attachFile.fileId))
                .where(travelAgencyList.deleted.eq(false),travelAgencyList.title.contains(travelAgencyTitleName))
                .orderBy(travelAgencyList.sort.asc())
                .fetch();
        return new PageImpl<>(travelAgencyListPage, pageable, travelAgencyListPage.size());
    }

    @Override
    public Optional<TravelAgencyListOnlyListDto> findCustomByDetail(Long ListId, boolean deleted) {
        return Optional.ofNullable(queryFactory.select(Projections.bean(TravelAgencyListOnlyListDto.class,
                        travelAgencyList.id.as("id"),
                        travelAgencyList.travelAgency.id.as("travel_agency_id"),
                        travelAgencyList.travelAgency.name.as("travel_name"),
                        travelAgencyList.city.as("city"),
                        travelAgencyList.readCount.as("read_count"),
                        travelAgencyList.content.as("content"),
                        travelAgencyList.personCount.as("person_count"),
                        travelAgencyList.personMaxCount.as("person_max_count"),
                        travelAgencyList.realPaid.as("real_paid"),
                        travelAgencyList.salePaid.as("sale_paid"),
                        travelAgencyList.salePercent.as("sale_percent"),
                        attachFile.filePath.as("filePath"),
                        travelAgencyList.sort.as("sort"),
                        travelAgencyList.travelStartAt.as("travel_start_at"),
                        travelAgencyList.travelEndAt.as("travel_end_at"),
                        travelAgencyList.title.as("title")))
                .from(travelAgencyList)
                .leftJoin(attachFile)
                .on(travelAgencyList.thumnbnailFileId.eq(attachFile.fileId))
                .where(travelAgencyList.deleted.eq(false),
                        travelAgencyList.id.eq(ListId))
                .orderBy(travelAgencyList.sort.asc())
                .fetchOne());
    }


}
