package UMC_9th.AhanOn.domain.book.service;

import UMC_9th.AhanOn.domain.book.code.HashErrorCode;
import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.book.entity.Hashtag;
import UMC_9th.AhanOn.domain.book.entity.dto.HashtagDto;
import UMC_9th.AhanOn.domain.book.exception.HashtagException;
import UMC_9th.AhanOn.domain.book.repository.BookRepository;
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
    private final BookRepository bookRepository;

    @Transactional
    public Hashtag createHashtag(HashtagDto.CreateRequest request) {

        Book book = bookRepository.findById(request.getBookId()).orElseThrow(
                () -> new HashtagException(HashErrorCode.NOT_FOUND_HASHTAG)
        );

        String hashtag = request.getHashtag();

        nomerization(hashtag);

        boolean existsByBookIdAndHashtag = hashtagRepository.existsByBookIdAndHashtag(book.getId(), hashtag);
        if (existsByBookIdAndHashtag) return hashtagRepository.findByBookIdAndHashtag(book.getId(), hashtag).get();

        return Hashtag.builder()
                .hashtag(hashtag)
                .book(book)
                .build();
    }

    @Transactional
    public void deleteHashtag(Book book, String hashtag) {
        Optional<Hashtag> byBookIdAndHashtag = hashtagRepository.findByBookIdAndHashtag(book.getId(), hashtag);
        byBookIdAndHashtag.ifPresent(hashtagRepository::delete);
        return;
    }

    public List<Hashtag> findAllByBook(Book book) {
        return hashtagRepository.findAllByBookId(book.getId());
    }

    private void nomerization(String str) {
        if (str == null || str.isBlank()) {
            throw new HashtagException(HashErrorCode.BAD_REQUEST_HASHTAG_EMPTY);
        }
    }
}
