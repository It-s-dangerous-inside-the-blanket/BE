package UMC_9th.AhanOn.domain.book.service;

import UMC_9th.AhanOn.domain.book.code.BookErrorCode;
import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.book.entity.Hashtag;
import UMC_9th.AhanOn.domain.book.entity.dto.BookConverter;
import UMC_9th.AhanOn.domain.book.entity.dto.BookDto;
import UMC_9th.AhanOn.domain.book.exception.BookException;
import UMC_9th.AhanOn.domain.book.repository.BookRepository;
import UMC_9th.AhanOn.domain.user.entity.User;
import UMC_9th.AhanOn.domain.user.repository.UserRepository;
import UMC_9th.AhanOn.global.apiPayload.code.GeneralErrorCode;
import UMC_9th.AhanOn.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final HashtagService hashtagService;

    public BookDto.Response createBook(BookDto.CreateRequest request, Long userId) {
        Book book = Book.builder()
                .title(request.getTitle())
                .existComment(request.isExistComment())
                .build();

        Book savedBook = bookRepository.save(book);

        User user = userRepository.findById(userId).orElseThrow(() -> new GeneralException(GeneralErrorCode.BAD_REQUEST));
        user.addBook(savedBook);

        for (String hashtag : request.getHashtags()) {
            Hashtag ht = hashtagService.createHashtag(savedBook, hashtag);
            book.addHashtag(ht);
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

    public BookDto.Response updateCompleteBook(Long bookId, boolean complete) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookException(BookErrorCode.NOT_FOUND_BOOK));
        book.updateIsEnd(complete);
        return BookConverter.toResponse(book);
    }
}
