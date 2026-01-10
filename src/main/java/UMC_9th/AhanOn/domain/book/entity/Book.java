package UMC_9th.AhanOn.domain.book.entity;

import UMC_9th.AhanOn.domain.chapter.entity.Chapter;
import UMC_9th.AhanOn.domain.dailyComment.entity.DailyComment;
import UMC_9th.AhanOn.domain.user.entity.User;
import UMC_9th.AhanOn.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookSummary;

    @Builder.Default
    private boolean isEnd = false;

    @NonNull
    private boolean existComment;

    private String commentAfterFin;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "user_id", nullable=false)
    @Setter
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    List<Hashtag> hashtags = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapterList = new ArrayList<>();

    public void addHashtag(Hashtag hashtag) {
        this.hashtags.add(hashtag);
        hashtag.setBook(this);
    }

    public void summaryBook (String summary){
        this.bookSummary = summary;
    }
}
