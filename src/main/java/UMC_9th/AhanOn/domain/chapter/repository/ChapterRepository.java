package UMC_9th.AhanOn.domain.chapter.repository;

import UMC_9th.AhanOn.domain.chapter.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    List<Chapter> findAllByBook_Id(Long bookId);
}
