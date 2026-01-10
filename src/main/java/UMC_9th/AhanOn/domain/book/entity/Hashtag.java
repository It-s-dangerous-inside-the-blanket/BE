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
