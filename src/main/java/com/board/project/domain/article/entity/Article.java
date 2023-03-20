package com.board.project.domain.article.entity;

import com.board.project.domain.user.entity.UserAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})

@Entity
public class Article extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false)
    private UserAccount userAccount;
    @Setter @Column(nullable = false) private String title;
    @Setter @Column(nullable = true) private String hashtag;

    @Setter @Column(nullable = false, length = 10000) private String content;

    @ToString.Exclude
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "article" ,cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    public Article() {}

    private Article(UserAccount userAccount, String title, String hashtag, String content) {
        this.userAccount = userAccount;
        this.title = title;
        this.hashtag = hashtag;
        this.content = content;
    }

    private Article(Long id, UserAccount userAccount, String title, String hashtag, String content) {
        this.id = id;
        this.userAccount = userAccount;
        this.title = title;
        this.hashtag = hashtag;
        this.content = content;
    }

    public static Article of(UserAccount userAccount, String title, String hashtag, String content) {
        return new Article(userAccount, title, content, hashtag);
    }

    public static Article of(Long id, UserAccount userAccount, String title, String hashtag, String content) {
        return new Article(id, userAccount, title, content, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article that)) return false;
        return this.getId() != null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
