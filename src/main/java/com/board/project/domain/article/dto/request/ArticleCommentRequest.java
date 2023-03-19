package com.board.project.domain.article.dto.request;

import com.board.project.domain.article.dto.ArticleCommentDto;
import com.board.project.domain.user.dto.UserAccountDto;

public record ArticleCommentRequest(
        Long articleId,
        String content
) {

    public static ArticleCommentRequest of(Long articleId ,String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }
}
