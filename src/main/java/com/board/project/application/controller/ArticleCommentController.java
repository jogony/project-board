package com.board.project.application.controller;

import com.board.project.application.usacase.CreateArticleCommentUsacase;
import com.board.project.domain.article.dto.request.ArticleCommentRequest;
import com.board.project.domain.article.service.ArticleCommentService;
import com.board.project.domain.user.dto.UserAccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;
    private final CreateArticleCommentUsacase createArticleCommentUsacase;

    @PostMapping("/new")
    public String postNewArticleComment(ArticleCommentRequest articleCommentRequest) {
        //TODO: 인증 정보를 넣어줘야 한다.
        createArticleCommentUsacase.saveArticleComment(articleCommentRequest.toDto(UserAccountDto.of(
                "ksw", "pw", "ksw@mail.com", null, null
        )));

        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping("/{commentId}/delete")
    public String deleteArticleComment(
            @PathVariable Long commentId
            ,Long articleId
    ) {
        articleCommentService.deleteArticleComment(commentId);
        return "redirect:/articles/" + articleId;
    }
}
