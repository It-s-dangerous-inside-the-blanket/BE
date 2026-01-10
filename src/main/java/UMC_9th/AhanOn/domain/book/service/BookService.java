package UMC_9th.AhanOn.domain.book.service;

import UMC_9th.AhanOn.domain.book.code.BookErrorCode;
import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.book.entity.Hashtag;
import UMC_9th.AhanOn.domain.book.entity.dto.BookConverter;
import UMC_9th.AhanOn.domain.book.entity.dto.BookDto;
import UMC_9th.AhanOn.domain.book.exception.BookException;
import UMC_9th.AhanOn.domain.book.repository.BookRepository;
import UMC_9th.AhanOn.domain.chapter.service.ChapterService;
import UMC_9th.AhanOn.domain.user.entity.User;
import UMC_9th.AhanOn.domain.user.repository.UserRepository;
import UMC_9th.AhanOn.global.apiPayload.code.GeneralErrorCode;
import UMC_9th.AhanOn.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final HashtagService hashtagService;
    private final ChapterService chapterService;

    @Transactional
    public BookDto.Response createBook(BookDto.CreateRequest request, Long userId) {
        Book book = Book.builder()
                .title(request.getTitle())
                .existComment(request.isExistComment())
                .build();

        Book savedBook = bookRepository.save(book);

        User user = userRepository.findById(userId).orElseThrow(() -> new GeneralException(GeneralErrorCode.BAD_REQUEST));
        user.addBook(savedBook);

        List<String> tags = request.getHashtags();

        //해시태그가 있는 경우에만 실행
        if (tags != null && !tags.isEmpty()) {
            for (String hashtag : tags) {
                Hashtag ht = hashtagService.createHashtagOri(savedBook, hashtag);
                book.addHashtag(ht);
            }
        }

        return BookConverter.toResponse(book);
    }

    public List<BookDto.Response> searchBookList(Long userId) {
        List<Book> books = bookRepository.findAllByUserId(userId);

        if (books.isEmpty()) return null;

        List<BookDto.Response> responses = new ArrayList<>();
        for (Book book : books) {
            BookDto.Response response = BookConverter.toResponse(book);
            responses.add(response);
        }
        return responses;
    }

    @Transactional
    public BookDto.Response updateCompleteBook(Long bookId, boolean complete) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookException(BookErrorCode.NOT_FOUND_BOOK));
        book.updateIsEnd(complete);

        //LLM이 요약 할 수 있도록 메서드 호출
        chapterService.completeBook(bookId);

        //User에 완료된 책 수 증가시키기
        book.getUser().increaseCompletedBookCount();

        return BookConverter.toResponse(book);
    }

    public BookDto.ResponseSummary getBookSummary(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookException(BookErrorCode.NOT_FOUND_BOOK));

        if (!book.isEnd()) throw new BookException(BookErrorCode.NOT_ENDDED_BOOK);

        if (!Objects.equals(book.getUser().getId(), userId)) {
            throw new BookException(BookErrorCode.NOT_OWNER_OF_BOOK);
        }

        String bookSummary = book.getBookSummary();
        BookDto.ResponseSummary build = BookDto.ResponseSummary.builder()
                .title(book.getTitle())
                .bookSummary(bookSummary)
                .createdAt(book.getCreatedAt())
                .build();
        return build;

    }
}
