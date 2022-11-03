package com.boardsite.adm.boardsiteadm.dto.request.article;


import com.boardsite.adm.boardsiteadm.dto.article.ArticleDto;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

public record ArticleRequest(
        String title,
        String content

)
{
    public static ArticleRequest of(String title, String content) {
        return new ArticleRequest(title, content);
    }
    public ArticleDto toDto(TripUserDto tripUserDto){
        return ArticleDto.of(
                tripUserDto,
                title,
                content
        );
    }
}
