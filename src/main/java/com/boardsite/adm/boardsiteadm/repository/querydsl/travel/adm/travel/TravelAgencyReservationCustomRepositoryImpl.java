package com.boardsite.adm.boardsiteadm.repository.querydsl.travel.adm.travel;

import com.boardsite.adm.boardsiteadm.domain.common.QAttachFile;
import com.boardsite.adm.boardsiteadm.domain.travel.QTravelAgencyReservation;
import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgencyReservation;
import com.boardsite.adm.boardsiteadm.dto.response.adm.dashboard.TravelListCountDto;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyReservationOnlyListDto;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TravelAgencyReservationCustomRepositoryImpl extends QuerydslRepositorySupport implements TravelAgencyReservationCustomRepository {
    private final JPAQueryFactory queryFactory;

    public TravelAgencyReservationCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        super(TravelAgencyReservation.class);
        this.queryFactory = queryFactory;
    }



    QTravelAgencyReservation reservation = QTravelAgencyReservation.travelAgencyReservation;
    QAttachFile attachFile = QAttachFile.attachFile;
    QAttachFile achfile = new QAttachFile("achfile");
    @Override
    public List<TravelListCountDto> findTravelAgencyReservation(Long travelAgencyId, String auth) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String formatedNow = now.format(formatter);
        String startDay = formatedNow+"-01 00:00:00.000000";
        String endDay = formatedNow+"-31 23:59:59.999999";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(startDay, formatter1);
        LocalDateTime dateTime2 = LocalDateTime.parse(endDay, formatter1);
        if(auth.equals("ADMIN")) {
            return queryFactory.select(Projections.bean(TravelListCountDto.class, reservation.count().as("count"), formattedDate.as("create")))
                    .from(reservation)
                    .where(reservation.deleted.eq(false),
                            reservation.travelAgency.id.eq(travelAgencyId),
                            reservation.createdAt.between(dateTime, dateTime2)
                    ).groupBy(formattedDate)
                    .fetch();
        } else {
                var aaaa = queryFactory.select(Projections.bean(TravelListCountDto.class, reservation.count().as("count"), formattedDate.as("create")))
                        .from(reservation)
                        .where(reservation.deleted.eq(false),
                                reservation.createdAt.between(dateTime, dateTime2)
                        ).groupBy(formattedDate)
                        .fetch();
            return queryFactory.select(Projections.bean(TravelListCountDto.class, reservation.count().as("count"), formattedDate.as("create")))
                    .from(reservation)
                    .where(reservation.deleted.eq(false),
                            reservation.createdAt.between(dateTime, dateTime2)
                    ).groupBy(formattedDate)
                    .fetch();
        }

    }

    @Override
    public PageImpl<TravelAgencyReservationOnlyListDto> findCustomList(Long id, Pageable pageable) {
        var reservationDto =  queryFactory.select(
                        Projections.bean(TravelAgencyReservationOnlyListDto.class,
                                ExpressionUtils.as(
                                        JPAExpressions.select(achfile.filePath)
                                                .from(achfile)
                                                .where(achfile.fileId.eq(reservation.travelAgencyList.thumnbnailFileId)),"thumbPath"),
                                ExpressionUtils.as(
                                        JPAExpressions.select(achfile.filePath)
                                                .from(achfile)
                                                .where(achfile.fileId.eq(reservation.qrCodeId)),"filePath"),
                                reservation.id.as("id"),
                                reservation.travelAgency.id.as("travelAgencyId"),
                                reservation.travelAgencyList.id.as("travelAgencyListId"),
                                reservation.tripUser.as("tripUser"),
                                reservation.merchantUid.as("merchantUid"),
                                reservation.impUid.as("impUid"),
                                reservation.payEmail.as("payEmail"),
                                reservation.payName.as("payName"),
                                reservation.paid.as("paid"),
                                reservation.realPaid.as("realPaid"),
                                reservation.personCount.as("personCount"),
                                reservation.salePercent.as("salePercent"),
                                reservation.deleted.as("deleted"),
                                reservation.qrCodeId.as("qrCodeId"),
                                reservation.qrChk.as("qrChk"),
                                reservation.travelAgency.as("travelAgencyDto"),
                                reservation.travelAgencyList.as("travelAgencyListDto"),
                                reservation.createdAt.as("createdAt")))
                .from(reservation)
                .where(reservation.tripUser.id.eq(id))
                .orderBy(reservation.createdAt.desc())
                .fetch();

        return new PageImpl<>(reservationDto, pageable, reservationDto.size());

    }

    //MYsql 날짜 비교 시 ...
    StringTemplate formattedDate = Expressions.stringTemplate(
            "DATE_TRUNC('day', {0})"
            , reservation.createdAt);


}
