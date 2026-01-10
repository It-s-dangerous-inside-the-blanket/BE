package UMC_9th.AhanOn.domain.chapter.repository;

import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.chapter.entity.Chapter;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    List<Chapter> findAllByBook_Id(Long bookId);

//    @Query("SELECT c FROM Chapter c WHERE c.book = :book AND CAST(c.createdAt AS date) = :date")
//    Optional<Chapter> findByBookAndCreatedAtDate(@Param("book") Book book, @Param("date") LocalDate date);

//    List<Chapter> findByBookAndCreatedAtDate(Book book, LocalDate date);

    @Query("SELECT c FROM Chapter c " +
            "WHERE c.book = :book " +
            "AND CAST(c.createdAt AS date) = :date " +
            "ORDER BY c.createdAt DESC")
    List<Chapter> findByBookAndDate(@Param("book") Book book, @Param("date") LocalDate date);
//    List<Chapter> findByBookAndCreatedAtDateOrderByCreatedAtDesc(Book book, LocalDate date);
}
