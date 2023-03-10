package com.board.project.domain.article.service;

import com.board.project.domain.article.dto.ArticleDto;
import com.board.project.domain.article.dto.ArticleUpdateDto;
import com.board.project.domain.article.repository.ArticleRepository;
import com.board.project.domain.article.type.SearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    //조회만 하기 때문
    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType title, String searchKeyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {
        // TODO document why this method is empty
    }

    public void updateArticle(long articleId, ArticleUpdateDto articleUpdateDto) {
        // TODO document why this method is empty
    }

    public void deleteArticle(long l) {
        // TODO document why this method is empty
    }
}
