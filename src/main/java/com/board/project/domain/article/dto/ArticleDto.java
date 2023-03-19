package com.board.project.domain.article.dto;

import com.board.project.domain.article.entity.Article;
import com.board.project.domain.user.dto.UserAccountDto;

import java.time.LocalDateTime;

public record ArticleDto (
        Long id,
        UserAccountDto userAccountDto,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static ArticleDto of(
            Long id,
            UserAccountDto userAccountDto,
            String title,
            String content,
            String hashtag,
            LocalDateTime createdAt,
            String createdBy,
            LocalDateTime modifiedAt,
            String modifiedBy
    ) {
        return new ArticleDto(
                id,
                userAccountDto,
                title,
                content,
                hashtag,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy
        );
    }

    public static ArticleDto from(Article entity) {
        return new ArticleDto(
                entity.getId(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public static ArticleDto of(
            UserAccountDto userAccountDto,
            String title,
            String content,
            String hashtag
    ) {
        return new ArticleDto(null, userAccountDto, title, content, hashtag, null, null, null, null);
    }

    public static ArticleDto of(
            Long id,
            UserAccountDto userAccountDto,
            String title,
            String content,
            String hashtag
    ) {
        return new ArticleDto(id, userAccountDto, title, content, hashtag, null, null, null, null);
    }

    public Article toEntity() {
        return Article.of(
                id,
                userAccountDto.toEntity(),
                title,
                content,
                hashtag
        );
    }

    public Article toEntity(UserAccountDto userAccountDto) {
        return Article.of(
                userAccountDto.toEntity(),
                title,
                content,
                hashtag
        );
    }
}
