package UMC_9th.AhanOn.domain.book.controller;

import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.book.entity.dto.BookDto;
import UMC_9th.AhanOn.domain.book.service.BookService;
import UMC_9th.AhanOn.global.apiPayload.ApiResponse;
import UMC_9th.AhanOn.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    public ApiResponse<BookDto.Response> createBook(@RequestBody BookDto.CreateRequest request, Long userId) {
        BookDto.Response book = bookService.createBook(request, userId);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, book);
    }

    @PatchMapping("/completed/{bookId}")
    public ApiResponse<BookDto.Response> updateCompleted(@PathVariable Long bookId) {
        BookDto.Response response = bookService.updateCompleteBook(bookId, true);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, response);
    }

    @GetMapping("/list/{userId}")
    public ApiResponse<List<BookDto.Response>> searchMyBook(@PathVariable Long userId) {
        List<BookDto.Response> response = bookService.searchBookList(userId);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, response);
    }
}
