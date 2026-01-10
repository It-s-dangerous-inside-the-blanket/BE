package UMC_9th.AhanOn.domain.book.service;

import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.book.entity.Hashtag;
import UMC_9th.AhanOn.domain.book.entity.dto.HashtagDto;
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
//    private final BookRepository bookRepository;
//
//    @Transactional
//    public Hashtag createHashtag(HashtagDto.CreateRequest request) {
//
//        bookRepository.findById(request.getBookId()).orElseThrow(
//                () -> new
//        );
//
//        boolean existsByBookIdAndHashtag = hashtagRepository.existsByBookIdAndHashtag(book.getId(), hashtag);
//        if (existsByBookIdAndHashtag) return hashtagRepository.findByBookIdAndHashtag(book.getId(), hashtag).get();
//
//        return Hashtag.builder()
//                .hashtag(hashtag)
//                .book(book)
//                .build();
//    }

    @Transactional
    public void deleteHashtag(Book book, String hashtag) {
        Optional<Hashtag> byBookIdAndHashtag = hashtagRepository.findByBookIdAndHashtag(book.getId(), hashtag);
        byBookIdAndHashtag.ifPresent(hashtagRepository::delete);
        return;
    }

    public List<Hashtag> findAllByBook(Book book) {
        return hashtagRepository.findAllByBookId(book.getId());
    }
}
