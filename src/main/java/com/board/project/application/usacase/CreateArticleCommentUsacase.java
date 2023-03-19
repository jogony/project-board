package com.board.project.application.usacase;

import com.board.project.domain.article.dto.ArticleCommentDto;
import com.board.project.domain.article.dto.ArticleDto;
import com.board.project.domain.article.mapper.ArticleMapper;
import com.board.project.domain.article.service.ArticleCommentService;
import com.board.project.domain.article.service.ArticleService;
import com.board.project.domain.user.dto.UserAccountDto;
import com.board.project.domain.user.mapper.UserMapper;
import com.board.project.domain.user.service.UserAccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateArticleCommentUsacase {

    private final ArticleCommentService articleCommentService;
    private final ArticleService articleService;
    private final UserAccountService userAccountService;

    @Transactional
    public void saveArticleComment(ArticleCommentDto dto) {
        try {
            ArticleDto article = articleService.getArticle(dto.articleId());
            UserAccountDto userAccount =  userAccountService.getUserAccount(dto.userAccountDto().userId());

            articleCommentService.saveArticleComment(article, userAccount, dto);

        } catch (EntityNotFoundException e) {
            log.warn("댓글 저장 실패. 댓글 작성에 필요한 정보를 찾을 수 없습니다 - {}", e.getLocalizedMessage());
        }
    }
}