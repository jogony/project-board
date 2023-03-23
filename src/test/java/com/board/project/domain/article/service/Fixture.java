package com.board.project.domain.article.service;

import com.board.project.domain.article.dto.ArticleCommentDto;
import com.board.project.domain.article.dto.ArticleDto;
import com.board.project.domain.article.dto.ArticleWithCommentsDto;
import com.board.project.domain.article.dto.HashtagDto;
import com.board.project.domain.article.entity.Article;
import com.board.project.domain.article.entity.ArticleComment;
import com.board.project.domain.article.entity.Hashtag;
import com.board.project.domain.user.dto.UserAccountDto;
import com.board.project.domain.user.entity.UserAccount;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.Set;

public class Fixture {

    public static ArticleWithCommentsDto createArticleWithCommentsDto() {
        return ArticleWithCommentsDto.of(
                1L,
                createUserAccountDto(),
                Set.of(),
                "새 타이틀",
                "새 내용 #springboot",
                Set.of(HashtagDto.of("java")),
                LocalDateTime.now(),
                "ksw",
                LocalDateTime.now(),
                "ksw"
        );
    }
    public static Article createArticle() {
        return createArticle(1L);
    }

    public static Article createArticle(Long id) {
        Article article = Article.of(
                createUserAccount(),
                "새 타이틀",
                "새 내용 #springboot"
        );
        article.addHashtags(Set.of(
                createHashtag(1L, "java"),
                createHashtag(2L, "spring")
        ));
        ReflectionTestUtils.setField(article, "id", id);

        return article;
    }

    public static Hashtag createHashtag(String hashtagName) {
        return createHashtag(1L, hashtagName);
    }

    public static Hashtag createHashtag(Long id, String hashtagName) {
        Hashtag hashtag = Hashtag.of(hashtagName);
        ReflectionTestUtils.setField(hashtag, "id", id);

        return hashtag;
    }

    public static HashtagDto createHashtagDto() {
        return HashtagDto.of("java");
    }
    public static ArticleDto createArticleDto(String title, String content) {
        return ArticleDto.of(
                1L,
                createUserAccountDto(),
                title,
                content,
                null,
                LocalDateTime.now(),
                "Uno",
                LocalDateTime.now(),
                "Uno");
    }

    public static ArticleCommentDto createArticleCommentDto(Long id, Long parentCommentId, String content) {
        return ArticleCommentDto.of(
                id,
                1L,
                createUserAccountDto(),
                content,
                LocalDateTime.now(),
                "uno",
                LocalDateTime.now(),
                "uno"
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

    public static UserAccount createUserAccount() {
        return UserAccount.of(
                "ksw",
                "password",
                "ksw@gamil.com",
                "ksw",
                null
        );
    }

    public static UserAccount createUserAccount(String userId) {
        return UserAccount.of(
                userId,
                "password",
                "uno@email.com",
                "Uno",
                null
        );
    }
    
    

    public static ArticleComment createArticleComment(String content) {
        return ArticleComment.of(
                Article.of(createUserAccount(), "title", "content"),
                createUserAccount(),
                content
        );
    }

    public static ArticleDto createArticleDto() {
        return ArticleDto.of(
                createUserAccountDto(),
                "title",
                "content",
                Set.of(HashtagDto.of("java"))
        );
    }


    public static UserAccountDto createUserAccountDto() {
        return UserAccountDto.of(
                "uno",
                "pw",
                "uno@mail.com",
                "Uno",
                "memo",
                LocalDateTime.now(),
                "uno",
                LocalDateTime.now(),
                "uno"
        );
    }
}
