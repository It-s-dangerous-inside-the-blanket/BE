package UMC_9th.AhanOn.domain.book.entity.dto;

import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.book.entity.Hashtag;

public class BookConverter {

    public static BookDto.Response toResponse(Book book) {
        return BookDto.Response.builder()
                .title(book.getTitle())
                .bookSummary(book.getBookSummary())
                .isEnd(book.isEnd())
                .existComment(book.isExistComment())
                .hashtags(    book.getHashtags().stream()
                        .map(Hashtag::getHashtag)
                        .toList())
                .build();
    }
}
