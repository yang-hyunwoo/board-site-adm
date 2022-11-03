package com.boardsite.adm.boardsiteadm.controller.article;




import com.boardsite.adm.boardsiteadm.domain.constant.SearchType;
import com.boardsite.adm.boardsiteadm.dto.request.article.ArticleRequest;
import com.boardsite.adm.boardsiteadm.dto.response.Response;
import com.boardsite.adm.boardsiteadm.dto.response.article.ArticleResponse;
import com.boardsite.adm.boardsiteadm.dto.response.article.ArticleWithCommentsResponse;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import com.boardsite.adm.boardsiteadm.service.aritcle.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 게시판 클래스
 * @author cohouseol
 */
@RestController
@RequestMapping("/api/trip/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;


    @GetMapping("")
    public Response<Page<ArticleResponse>> articles(@RequestParam(required = false) SearchType searchType,
                                                    @RequestParam(required = false) String searchKeyWord,
                                                    @PageableDefault(size=10,sort="createdAt",direction= Sort.Direction.DESC)Pageable pageable) {

        Page<ArticleResponse> articles = articleService.articleSearchList(searchType,searchKeyWord,pageable).map(ArticleResponse::from);
        return Response.success(articles);
    }

    @GetMapping("/{articleId}")
    public Response<ArticleWithCommentsResponse> articleDetail(@PathVariable Long articleId,
                                                               @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {
        var articleDetail = ArticleWithCommentsResponse.from(articleService.getArticleWithComment(articleId),tripUserPrincipal);
        return Response.success(articleDetail);
    }

    @GetMapping("/valid/{articleId}")
    public Response<ArticleResponse> articleValidDetail(@PathVariable Long articleId,
                                                               @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {

        var articleValidDetail = ArticleResponse.from(articleService.articleValidDetail(articleId , tripUserPrincipal.id()));

        return Response.success(articleValidDetail);
    }

    @PostMapping("/new-article")
    public Response<Boolean> saveArticle(@Valid @RequestBody ArticleRequest articleRequest ,
                                         @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {
         articleService.saveArticle(articleRequest.toDto(tripUserPrincipal.toDto()));
    return Response.success(true);
    }

    @PostMapping("/{articleId}/form")
    public Response<Boolean> updateArticle(@PathVariable Long articleId ,
                                           @Valid @RequestBody ArticleRequest articleRequest ,
                                           @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal)
    {

        articleService.updateArticle(articleId,articleRequest.toDto(tripUserPrincipal.toDto()));
        return Response.success(true);
    }

    @PutMapping("/{articleId}/delete")
    public Response<Boolean> deleteArticle(@PathVariable Long articleId ,
                                           @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal)
    {
        articleService.deleteArticle(articleId , tripUserPrincipal.id());
        return Response.success(true);
    }


}
