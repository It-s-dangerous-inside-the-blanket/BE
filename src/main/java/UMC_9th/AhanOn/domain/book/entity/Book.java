package UMC_9th.AhanOn.domain.book.entity;

import UMC_9th.AhanOn.domain.BaseEntity;
import UMC_9th.AhanOn.domain.user.Entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookSummery;

    @Builder.Default
    private boolean isEnd = false;

    @NonNull
    private boolean existComment;

    private String commentAfterFin;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    @Setter
    private User user;

}
