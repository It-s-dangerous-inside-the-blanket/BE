package UMC_9th.AhanOn.domain.book.service;

import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.book.entity.Hashtag;
import UMC_9th.AhanOn.domain.book.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HashtagService {

    private final HashtagRepository hashtagRepository;

    @Transactional
    public Hashtag createHashtag(Book book, String hashtag) {
        boolean existsByBookIdAndHashtag = hashtagRepository.existsByBookIdAndHashtag(book.getId(), hashtag);
        if (existsByBookIdAndHashtag) return null;

        return Hashtag.builder()
                .hashtag(hashtag)
                .book(book)
                .build();
    }

    @Transactional
    public void deleteHashtag(Book book, String hashtag) {
        Optional<Hashtag> byBookIdAndHashtag = hashtagRepository.findByBookIdAndHashtag(book.getId(), hashtag);
        if (byBookIdAndHashtag.isPresent()) {
            hashtagRepository.delete(byBookIdAndHashtag.get());
        }
        return;
    }

    public List<Hashtag> findAllByBook(Book book) {
        return hashtagRepository.findAllByBookId(book.getId());
    }
}
