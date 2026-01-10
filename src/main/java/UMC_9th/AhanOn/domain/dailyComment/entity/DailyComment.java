package UMC_9th.AhanOn.domain.dailyComment.entity;


import UMC_9th.AhanOn.domain.chapter.entity.Chapter;
import UMC_9th.AhanOn.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DailyComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chapter_id", nullable = false)
    @Setter
    private Chapter chapter;

    @Column(name = "comment", nullable = false, columnDefinition = "TEXT")
    private String comment;
}
