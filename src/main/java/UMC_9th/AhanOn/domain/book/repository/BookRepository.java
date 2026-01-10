package UMC_9th.AhanOn.domain.book.repository;

import UMC_9th.AhanOn.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findById(Long id);
    List<Book> findAllByUserId(Long userId);

    // 책 상세 조회 (해시태그까지 함께 fetch)
    @Query("SELECT b FROM Book b " +
            "LEFT JOIN FETCH b.hashtags " +
            "WHERE b.id = :bookId")
    Optional<Book> findByIdWithHashtags(@Param("bookId") Long bookId);
}
