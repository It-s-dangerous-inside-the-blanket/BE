package UMC_9th.AhanOn.domain.book.repository;

import UMC_9th.AhanOn.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findById(Long id);
    List<Book> findAllByUserId(Long userId);
}
