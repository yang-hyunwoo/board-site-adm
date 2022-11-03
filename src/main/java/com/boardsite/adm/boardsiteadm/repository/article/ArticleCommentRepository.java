package com.boardsite.adm.boardsiteadm.repository.article;

import com.boardsite.adm.boardsiteadm.domain.article.ArticleComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {

    List<ArticleComment> findByArticle_IdAndDeleted(Long articleId, boolean deleted);

    Page<ArticleComment> findByArticle_IdAndDeleted(Long articleId, boolean deleted, Pageable pageable);

    Optional<ArticleComment> findByIdAndDeleted(Long articleId , boolean deleted);
    void deleteByIdAndTripUser_Id(Long articleCommentId , Long id);
}
