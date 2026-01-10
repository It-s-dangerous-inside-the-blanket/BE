package UMC_9th.AhanOn.domain.chapter.entity;

import UMC_9th.AhanOn.domain.dailyComment.entity.DailyComment;
import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chapter extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "chapter_title", nullable = false, length = 50)
    private String title;

    @Lob
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyComment> comments = new ArrayList<>();

    public void addComment(DailyComment comment) {
        comments.add(comment);
        comment.setChapter(this);
    }
}
