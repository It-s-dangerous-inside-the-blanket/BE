package UMC_9th.AhanOn.domain.dailyComment.repository;

import UMC_9th.AhanOn.domain.dailyComment.entity.DailyComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyCommentRepository extends JpaRepository<DailyComment, Long> {

}
