package UMC_9th.AhanOn.domain.book.repository;

import UMC_9th.AhanOn.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
