package UMC_9th.AhanOn.domain.DailyComment.entity;


import UMC_9th.AhanOn.domain.BaseEntity;
import UMC_9th.AhanOn.domain.chapter.entity.Chapter;
import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "daily_comments")
public class DailyComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK: chapter_id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chapter_id", nullable = false)
    @Setter
    private Chapter chapter;

    @Lob
    @Column(name = "comment", nullable = false)
    private String comment;
}
