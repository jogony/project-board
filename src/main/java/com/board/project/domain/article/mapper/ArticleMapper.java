package com.board.project.domain.article.mapper;

import com.board.project.domain.article.dto.ArticleCommentDto;
import com.board.project.domain.article.dto.ArticleDto;
import com.board.project.domain.article.entity.Article;
import com.board.project.domain.article.entity.ArticleComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    Article toArticleEntity(ArticleDto articleDto);

    ArticleDto toArticleDto(Article article);

    ArticleComment toArticleCommentEntity(ArticleCommentDto articleCommentDto);

    ArticleCommentDto toArticleCommentDto(ArticleComment articleComment);
}
