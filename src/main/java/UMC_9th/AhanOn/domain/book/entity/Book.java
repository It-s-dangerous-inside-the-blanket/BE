package UMC_9th.AhanOn.domain.book.entity;

import UMC_9th.AhanOn.domain.user.entity.User;
import UMC_9th.AhanOn.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(
        name = "book",
        indexes = {
                @Index(name = "ix_book_user_id", columnList = "user_id")
        }
)
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String bookSummary;

    @Builder.Default
    private boolean isEnd = false;

    @NonNull
    private boolean existComment;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "user_id", nullable=false)
    @Setter
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    @Builder.Default
    List<Hashtag> hashtags = new ArrayList<>();

    public void addHashtag(Hashtag hashtag) {
        this.hashtags.add(hashtag);
        hashtag.setBook(this);
    }

    public void update(String title, Boolean isEnd, Boolean existComment) {
        if (title != null) this.title = title;
        if (isEnd != null) this.isEnd = isEnd;
        if (existComment != null) this.existComment = existComment;
    }

    public void updateIsEnd(Boolean isEnd) {
        if (isEnd != null) this.isEnd = isEnd;
    }
}
