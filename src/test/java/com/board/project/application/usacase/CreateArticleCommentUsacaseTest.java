package com.board.project.application.usacase;

import com.board.project.domain.article.dto.ArticleCommentDto;
import com.board.project.domain.article.dto.ArticleDto;
import com.board.project.domain.article.service.ArticleCommentService;
import com.board.project.domain.article.service.ArticleService;
import com.board.project.domain.article.service.Fixture;
import com.board.project.domain.user.dto.UserAccountDto;
import com.board.project.domain.user.service.UserAccountService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("Usacase 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class CreateArticleCommentUsacaseTest {

    @InjectMocks
    private CreateArticleCommentUsacase sut;

    @Mock private ArticleCommentService articleCommentService;
    @Mock
    private ArticleService articleService;
    @Mock private UserAccountService userAccountService;

    @DisplayName("댓글 저장을 시도했는데 맞는 게시글이 없으면, 경고 로그를 찍고 아무것도 안 한다.")
    @Test
    void givenNonexistentArticle_whenSavingArticleComment_thenLogsSituationAndDoesNothing() {
        // Given
        ArticleCommentDto dto = Fixture.createArticleCommentDto("댓글");
        ArticleDto article = Fixture.createArticleDto();
        UserAccountDto userAccount = Fixture.createUserAccountDto();
        given(articleService.getArticle(dto.articleId())).willThrow(EntityNotFoundException.class);

        // When
        sut.saveArticleComment(dto);

        // Then
        then(articleService).should().getArticle(dto.articleId());
        then(userAccountService).shouldHaveNoInteractions();
        then(articleCommentService).shouldHaveNoInteractions();
    }
}