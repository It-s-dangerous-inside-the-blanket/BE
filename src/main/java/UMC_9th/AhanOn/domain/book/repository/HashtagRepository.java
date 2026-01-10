package UMC_9th.AhanOn.domain.book.repository;

import UMC_9th.AhanOn.domain.book.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

    List<Hashtag> findAllByBookId(Long bookId);

    boolean existsByBookIdAndHashtag(Long bookId, String hashtag);

    void deleteAllByBookId(Long bookId);

    Optional<Hashtag> findByBookIdAndHashtag(Long bookId, String hashtag);
}
