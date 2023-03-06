package com.board.project.domain;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private String title;
    private String hashtag;
    private String content;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifedAt;
    private String modifiedBy;
}
