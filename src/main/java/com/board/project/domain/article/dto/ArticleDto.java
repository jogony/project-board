package com.board.project.domain.article.dto;

import com.board.project.domain.article.entity.Article;
import com.board.project.domain.user.dto.UserAccountDto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record ArticleDto (
        Long id,
        UserAccountDto userAccountDto,
        String title,
        String content,
        Set<HashtagDto> hashtagDtos,
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
            Set<HashtagDto> hashtagDtos,
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
                hashtagDtos,
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
                entity.getHashtags().stream()
                        .map(HashtagDto::from)
                        .collect(Collectors.toUnmodifiableSet()),
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
            Set<HashtagDto> hashtagDtos
    ) {
        return new ArticleDto(null, userAccountDto, title, content, hashtagDtos, null, null, null, null);
    }

    public static ArticleDto of(
            Long id,
            UserAccountDto userAccountDto,
            String title,
            String content,
            Set<HashtagDto> hashtagDtos
    ) {
        return new ArticleDto(id, userAccountDto, title, content, hashtagDtos, null, null, null, null);
    }

    public Article toEntity() {
        return Article.of(
                id,
                userAccountDto.toEntity(),
                title,
                content
        );
    }

    public Article toEntity(UserAccountDto userAccountDto) {
        return Article.of(
                userAccountDto.toEntity(),
                title,
                content
        );
    }
}
