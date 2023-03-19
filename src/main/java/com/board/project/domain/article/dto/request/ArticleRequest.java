package com.board.project.domain.article.dto.request;

import com.board.project.domain.article.dto.ArticleDto;
import com.board.project.domain.user.dto.UserAccountDto;

public record ArticleRequest(
        String title,
        String content,
        String hashtag
) {

    public static ArticleRequest of(String title, String content, String hashtag) {
        return new ArticleRequest(title, content, hashtag);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto) {
        return ArticleDto.of(
                userAccountDto,
                title,
                content,
                hashtag
        );
    }

    public ArticleDto toDto(Long articleId, UserAccountDto userAccountDto) {
        return ArticleDto.of(
                articleId,
                userAccountDto,
                title,
                content,
                hashtag
        );
    }

}
