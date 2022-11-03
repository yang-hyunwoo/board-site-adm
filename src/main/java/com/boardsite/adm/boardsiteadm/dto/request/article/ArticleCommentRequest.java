package com.boardsite.adm.boardsiteadm.dto.request.article;


import com.boardsite.adm.boardsiteadm.dto.article.ArticleCommentDto;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

public record ArticleCommentRequest(
        Long articleId,
        String content
)
{
    public static ArticleCommentRequest of(Long articleId,String content) {
        return new ArticleCommentRequest(articleId,content);
    }

    public ArticleCommentDto toDto(TripUserDto tripUserDto){
        return ArticleCommentDto.of(
                articleId,
                tripUserDto,
                content
        );
    }
}
