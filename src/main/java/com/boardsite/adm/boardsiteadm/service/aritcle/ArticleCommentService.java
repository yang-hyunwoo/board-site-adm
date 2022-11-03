package com.boardsite.adm.boardsiteadm.service.aritcle;

import com.boardsite.adm.boardsiteadm.domain.article.Article;
import com.boardsite.adm.boardsiteadm.domain.article.ArticleComment;
import com.boardsite.adm.boardsiteadm.domain.user.TripUser;
import com.boardsite.adm.boardsiteadm.dto.article.ArticleCommentDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.article.ArticleCommentRepository;
import com.boardsite.adm.boardsiteadm.repository.article.ArticleRepository;
import com.boardsite.adm.boardsiteadm.repository.user.TripUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;

    private final ArticleRepository articleRepository;

    private final TripUserRepository tripUserRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComments(Long articleId) {
        return articleCommentRepository.findByArticle_IdAndDeleted(articleId,false)
                .stream().map(ArticleCommentDto::from).toList();
    }

    @Transactional(readOnly = true)
    public Page<ArticleCommentDto> searchArticleCommentsPage(Long articleId,Pageable pageable) {
        return articleCommentRepository.findByArticle_IdAndDeleted(articleId,false,pageable).map(ArticleCommentDto::from);
    }

    @Transactional
    public void saveArticleComment(ArticleCommentDto dto) {
        try {
            Article article = articleRepository.findByIdAndDeleted(dto.articleId(),false).orElseThrow(()->new BoardSiteException(ErrorCode.ARTICLE_NOT_FOUND));
            TripUser tripUser = tripUserRepository.getReferenceById(dto.tripUser().id());
            articleCommentRepository.save(dto.toEntity(article, tripUser));
        } catch (Exception e) {
            throw new BoardSiteException(ErrorCode.EMAIL_NOT_FOUND);
        }
    }

    @Transactional
    public void updateArticleComment(Long articleCommentId , ArticleCommentDto dto){

        ArticleComment articleComment = articleCommentRepository.findByIdAndDeleted(articleCommentId,false).orElseThrow(()->new BoardSiteException(ErrorCode.ARTICLE_NOT_FOUND));
        TripUser tripUser = tripUserRepository.getReferenceById(dto.tripUser().id());
        if(articleComment.getTripUser().getId().equals(tripUser.getId())) {
            if (dto.content() != null) {
                articleComment.setContent(dto.content());
                }
        } else {
            throw  new BoardSiteException(ErrorCode.ARTICLE_COMMENT_UNAUTHORIZED);
        }

    }

    @Transactional
    public void deleteArticleComment(Long articleCommentId , Long userId) {
            ArticleComment articleComment = articleCommentRepository.findByIdAndDeleted(articleCommentId,false).orElseThrow(()->new BoardSiteException(ErrorCode.ARTICLE_NOT_FOUND));
            TripUser tripUser = tripUserRepository.getReferenceById(userId);

            if (articleComment.getTripUser().getId().equals(tripUser.getId())) {
                articleComment.setDeleted(true);
            } else{
                throw new BoardSiteException(ErrorCode.ARTICLE_COMMENT_UNAUTHORIZED);
            }
    }
}
