package com.boardsite.adm.boardsiteadm.controller.adm.article;

import com.boardsite.adm.boardsiteadm.dto.request.article.ArticleCommentRequest;
import com.boardsite.adm.boardsiteadm.dto.response.Response;
import com.boardsite.adm.boardsiteadm.dto.response.article.ArticleCommentResponse;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import com.boardsite.adm.boardsiteadm.service.adm.article.AdmArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * 게시판 댓글 클래스
 * @author cohouseol
 */
@RestController
@RequestMapping("/api/adm/articles")
@RequiredArgsConstructor
public class AdmArticleCommentController {

    private final AdmArticleCommentService admArticleCommentService;

    /*
       게시판 댓글 리스트 조회
     */
    @GetMapping("/comment/{articleId}")
    public Response<Page<ArticleCommentResponse>> searchArticleCommentsPage(@PathVariable Long articleId ,
                                                                            @PageableDefault(size=8,sort="createdAt",direction= Sort.Direction.DESC) Pageable pageable,
                                                                            @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {

        Page<ArticleCommentResponse> articleComments = admArticleCommentService.searchArticleCommentsPage(articleId,pageable).map(ArticleCommentResponse::from);
        return Response.success(articleComments);
    }

    /*
        게시판 댓글 생성
     */
    @PostMapping("/comment/new")
    public Response<Boolean> saveArticleComment(@RequestBody ArticleCommentRequest articleCommentRequest,
                                                @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal){
        admArticleCommentService.saveArticleComment(articleCommentRequest.toDto(tripUserPrincipal.toDto()));
        return Response.success(true);
    }

    /*
        게시판 댓글 수정
     */
    @PutMapping("/comment/{articleCommentId}/form")
    public Response<Boolean> updateArticleComment(@PathVariable Long articleCommentId,
                                                  @RequestBody ArticleCommentRequest articleCommentRequest,
                                                  @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal)
    {
        admArticleCommentService.updateArticleComment(articleCommentId,articleCommentRequest.toDto(tripUserPrincipal.toDto()));
        return Response.success(true);
    }

    /*
        게시판 댓글 삭제(deleted = true) upd
     */
    @PutMapping("/comment/{articleCommentId}/delete")
    public Response<Boolean> deleteArticleComment(@PathVariable Long articleCommentId,
                                                  @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal)
    {
        admArticleCommentService.deleteArticleComment(articleCommentId);

        return Response.success(true);
    }


}
