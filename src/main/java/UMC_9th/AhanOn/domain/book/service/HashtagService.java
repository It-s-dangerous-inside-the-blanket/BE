package UMC_9th.AhanOn.domain.book.service;

import UMC_9th.AhanOn.domain.book.code.BookErrorCode;
import UMC_9th.AhanOn.domain.book.code.HashErrorCode;
import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.book.entity.Hashtag;
import UMC_9th.AhanOn.domain.book.entity.dto.HashtagConverter;
import UMC_9th.AhanOn.domain.book.entity.dto.HashtagDto;
import UMC_9th.AhanOn.domain.book.exception.BookException;
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
    public HashtagDto.HashtagResponse createHashtag(HashtagDto.Request request) {

        Book book = bookRepository.findById(request.getBookId()).orElseThrow(
                () -> new BookException(BookErrorCode.NOT_FOUND_BOOK)
        );

        HashtagDto.HashtagResponse hashtag = createHashtag(book, request.getHashtag());

        return hashtag;
    }

    @Transactional
    public HashtagDto.HashtagResponse createHashtag(Book book, String hashtag) {

        String normalizationTag = normalization(hashtag);

        boolean existsByBookIdAndHashtag = hashtagRepository.existsByBookIdAndHashtag(book.getId(), normalizationTag);
        if (existsByBookIdAndHashtag) {
            Hashtag hashtag1 = hashtagRepository.findByBookIdAndHashtag(book.getId(), normalizationTag).get();
            return HashtagConverter.toResponse(hashtag1);
        }

        Hashtag build = Hashtag.builder()
                .hashtag(normalizationTag)
                .book(book)
                .build();

        return HashtagConverter.toResponse(build);
    }

    @Transactional
    public Hashtag createHashtagOri(Book book, String hashtag) {

        String normalizationTag = normalization(hashtag);

        boolean existsByBookIdAndHashtag = hashtagRepository.existsByBookIdAndHashtag(book.getId(), normalizationTag);
        if (existsByBookIdAndHashtag) {
            return hashtagRepository.findByBookIdAndHashtag(book.getId(), normalizationTag).get();
        }

        return Hashtag.builder()
                .hashtag(normalizationTag)
                .book(book)
                .build();
    }

    @Transactional
    public void deleteHashtag(HashtagDto.Request request) {

        Book book = bookRepository.findById(request.getBookId()).orElseThrow(
                () -> new HashtagException(HashErrorCode.NOT_FOUND_HASHTAG)
        );

        String hashtag = request.getHashtag();

        Optional<Hashtag> byBookIdAndHashtag = hashtagRepository.findByBookIdAndHashtag(book.getId(), hashtag);
        if (byBookIdAndHashtag.isPresent()) {
            hashtagRepository.delete(byBookIdAndHashtag.get());
        } else {
            throw new HashtagException(HashErrorCode.NOT_FOUND_HASHTAG);
        }
    }

    public List<Hashtag> findAllByBook(Book book) {
        return hashtagRepository.findAllByBookId(book.getId());
    }

    private String normalization(String str) {
        if (str == null) {
            throw new HashtagException(HashErrorCode.BAD_REQUEST_HASHTAG_NULL);
        }

        String normalized = str.trim();

        if (normalized.isEmpty()) {
            throw new HashtagException(HashErrorCode.BAD_REQUEST_HASHTAG_EMPTY);
        }

        return normalized;
    }
}
