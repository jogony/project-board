package com.board.project.domain.article.service;

import com.board.project.domain.article.dto.ArticleCommentDto;
import com.board.project.domain.article.dto.ArticleDto;
import com.board.project.domain.article.entity.Article;
import com.board.project.domain.article.entity.ArticleComment;
import com.board.project.domain.article.mapper.ArticleMapper;
import com.board.project.domain.article.repository.ArticleCommentRepository;
import com.board.project.domain.article.repository.ArticleRepository;
import com.board.project.domain.user.dto.UserAccountDto;
import com.board.project.domain.user.entity.UserAccount;
import com.board.project.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;
    private final ArticleMapper articleMapper;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(Long articleId) {
        return articleCommentRepository.findByArticle_Id(articleId)
                .stream()
                .map(ArticleCommentDto::from)
                .toList();
    }

    public void saveArticleComment(ArticleDto articleDto, UserAccountDto userAccountDto, ArticleCommentDto dto) {

        Article article = articleDto.toEntity();
        UserAccount userAccount =userAccountDto.toEntity();
        ArticleComment articleComment = dto.toEntity(article, userAccount);

        articleCommentRepository.save(articleComment);
    }

    public void deleteArticleComment(long articleCommentId, String userId) {
        articleCommentRepository.deleteByIdAndUserAccount_UserId(articleCommentId, userId);
    }
}
