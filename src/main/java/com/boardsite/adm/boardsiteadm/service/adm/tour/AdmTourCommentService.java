package com.boardsite.adm.boardsiteadm.service.adm.tour;

import com.boardsite.adm.boardsiteadm.domain.tour.Tour;
import com.boardsite.adm.boardsiteadm.domain.tour.TourComment;
import com.boardsite.adm.boardsiteadm.domain.user.TripUser;
import com.boardsite.adm.boardsiteadm.dto.tour.TourCommentDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.adm.tour.AdmTourCommentRepository;
import com.boardsite.adm.boardsiteadm.repository.adm.tour.AdmTourRepository;
import com.boardsite.adm.boardsiteadm.repository.user.TripUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdmTourCommentService {

    private final AdmTourCommentRepository admTourCommentRepository;

    private final AdmTourRepository admTourRepository;

    private final TripUserRepository tripUserRepository;

    @Transactional(readOnly = true)
    public List<TourCommentDto> searchTourComments(Long articleId) {
        return admTourCommentRepository.findByTour_IdAndDeleted(articleId,false)
                .stream().map(TourCommentDto::from).toList();
    }

    @Transactional(readOnly = true)
    public Page<TourCommentDto> searchTourCommentsPage(Long articleId,Pageable pageable) {
        return admTourCommentRepository.findByTour_IdAndDeleted(articleId,false,pageable).map(TourCommentDto::from);
    }

    @Transactional
    public void saveTourComment(TourCommentDto dto) {
        try {
            Tour tour = admTourRepository.findByIdAndDeleted(dto.tourId(),false).orElseThrow(()->new BoardSiteException(ErrorCode.TOUR_NOT_FOUND));
            TripUser tripUser = tripUserRepository.getReferenceById(dto.tripUser().id());
            admTourCommentRepository.save(dto.toEntity(tour, tripUser));
        } catch (Exception e) {
            throw new BoardSiteException(ErrorCode.EMAIL_NOT_FOUND);
        }
    }

    @Transactional
    public void updateTourComment(Long tourCommentId , TourCommentDto dto){

        TourComment tourComment = admTourCommentRepository.findByIdAndDeleted(tourCommentId,false).orElseThrow(()->new BoardSiteException(ErrorCode.TOUR_NOT_FOUND));
        TripUser tripUser = tripUserRepository.getReferenceById(dto.tripUser().id());
            if (dto.content() != null) {
                tourComment.setContent(dto.content());
                }

    }

    @Transactional
    public void deleteTourComment(Long tourCommentId , Long userId) {
            TourComment tourComment = admTourCommentRepository.findByIdAndDeleted(tourCommentId,false).orElseThrow(()->new BoardSiteException(ErrorCode.TOUR_NOT_FOUND));
            TripUser tripUser = tripUserRepository.getReferenceById(userId);

            tourComment.setDeleted(true);
    }
}
