package UMC_9th.AhanOn.domain.dailyComment.entity;


import UMC_9th.AhanOn.domain.chapter.entity.Chapter;
import UMC_9th.AhanOn.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Setter;

@Entity
public class DailyComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chapter_id", nullable = false)
    @Setter
    private Chapter chapter;

    @Lob
    @Column(name = "comment", nullable = false)
    private String comment;
}
