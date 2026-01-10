package UMC_9th.AhanOn.domain.book.entity;

import UMC_9th.AhanOn.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(
        name = "hashtag",
        indexes = {
                @Index(name = "ix_hashtag_book_id", columnList = "book_id"),
                @Index(name = "ix_hashtag_book_tag", columnList = "book_id, hashtag")
        }
)
public class Hashtag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hashtag;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "book_id", nullable=false)
    private Book book;

    public void setBook(Book book) {
        this.book = book;
    }
}
