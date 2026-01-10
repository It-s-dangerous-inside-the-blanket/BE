package UMC_9th.AhanOn.domain.book.controller;

import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.book.entity.dto.BookDto;
import UMC_9th.AhanOn.domain.book.service.BookService;
import UMC_9th.AhanOn.global.apiPayload.ApiResponse;
import UMC_9th.AhanOn.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Operation(
            summary = "책 생성",
            description = "사용자(userId)의 책을 생성합니다."
    )
    @PostMapping("/create")
    public ApiResponse<BookDto.Response> createBook(@RequestBody BookDto.CreateRequest request, Long userId) {
        BookDto.Response book = bookService.createBook(request, userId);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, book);
    }

    @Operation(
            summary = "책 완료 처리",
            description = "bookId에 해당하는 책을 완료 상태로 변경합니다."
    )
    @PatchMapping("/completed/{bookId}")
    public ApiResponse<BookDto.Response> updateCompleted(@PathVariable Long bookId) {
        BookDto.Response response = bookService.updateCompleteBook(bookId, true);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, response);
    }

    @Operation(
            summary = "내 책 목록 조회",
            description = "userId가 소유한 책 목록을 조회합니다."
    )
    @GetMapping("/list/{userId}")
    public ApiResponse<List<BookDto.Response>> searchMyBook(@PathVariable Long userId) {
        List<BookDto.Response> response = bookService.searchBookList(userId);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, response);
    }
}
