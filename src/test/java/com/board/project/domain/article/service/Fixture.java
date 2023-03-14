package com.board.project.domain.article.service;

import com.board.project.domain.article.dto.ArticleCommentDto;
import com.board.project.domain.article.dto.ArticleWithCommentsDto;
import com.board.project.domain.article.entity.Article;
import com.board.project.domain.article.entity.ArticleComment;
import com.board.project.domain.user.dto.UserAccountDto;
import com.board.project.domain.user.entity.UserAccount;

import java.time.LocalDateTime;
import java.util.Set;

public class Fixture {

    public static ArticleWithCommentsDto createArticleWithCommentsDto() {
        return ArticleWithCommentsDto.of(
                1L,
                createUserAccountDto(),
                Set.of(),
                "title",
                "content",
                "#java",
                LocalDateTime.now(),
                "ksw",
                LocalDateTime.now(),
                "ksw"
        );
    }

    public static Article createArticle() {
        return Article.of(
                createUserAccount(),
                "title",
                "content",
                "#java"
        );
    }

    public static ArticleCommentDto createArticleCommentDto(String content) {
        return ArticleCommentDto.of(
                1L,
                1L,
                createUserAccountDto(),
                content,
                LocalDateTime.now(),
                "ksw",
                LocalDateTime.now(),
                "ksw"
        );
    }

    public static UserAccountDto createUserAccountDto() {
        return UserAccountDto.of(
                "ksw",
                "password",
                "ksw@hami.com",
                "ksw",
                "this is memo",
                LocalDateTime.now(),
                "ksw",
                LocalDateTime.now(),
                "ksw"
        );
    }

    public static UserAccount createUserAccount() {
        return UserAccount.of(
                "ksw",
                "password",
                "ksw@gamil.com",
                "ksw",
                null
        );
    }

    public static ArticleComment createArticleComment(String content) {
        return ArticleComment.of(
                Article.of(createUserAccount(), "title", "content", "hashtag"),
                createUserAccount(),
                content
        );
    }
}
