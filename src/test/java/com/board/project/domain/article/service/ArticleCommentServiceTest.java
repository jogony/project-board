package com.board.project.domain.article.service;

import com.board.project.domain.article.dto.ArticleCommentDto;
import com.board.project.domain.article.entity.ArticleComment;
import com.board.project.domain.article.repository.ArticleCommentRepository;
import com.board.project.domain.article.repository.ArticleRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks
    private ArticleCommentService sut;
    @Mock
    private ArticleCommentRepository articleCommentRepository;
    @Mock
    private ArticleRepository articleRepository;

    @Disabled
    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchingComments_thenReturnsComments() {
        // Given
        Long articleId = 1L;
        ArticleComment expected = Fixture.createArticleComment("content");
        // When
        List<ArticleCommentDto> actual = sut.searchArticleComment(articleId);
        // Then
        assertThat(actual)
                .hasSize(1)
                .first().hasFieldOrPropertyWithValue("content", expected.getContent());
        then(articleCommentRepository).should().findByArticle_Id(articleId);
    }


    @Disabled
    @DisplayName("댓글 정보를 입력하면, 댓글을 저장한다.")
    @Test
    void givenArticleCommentsInfo_whenComments_thenReturnsComments() {
        // Given
        Long articleId = 1L;
        ArticleCommentDto dto = Fixture.createArticleCommentDto("댓글");
        given(articleRepository.getReferenceById(dto.articleId())).willReturn(Fixture.createArticle());
        // When
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);
        // Then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }




}