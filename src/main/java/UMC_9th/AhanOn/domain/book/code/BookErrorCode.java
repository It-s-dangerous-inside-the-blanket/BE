package UMC_9th.AhanOn.domain.book.code;

import UMC_9th.AhanOn.global.apiPayload.code.BaseErrorCode;
import UMC_9th.AhanOn.global.apiPayload.code.GeneralErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum BookErrorCode implements BaseErrorCode {


    //BOOK
    NOT_FOUND_BOOK(HttpStatus.NOT_FOUND, "BOOK4001", "존재하지 않는 책입니다"),

;


    private final HttpStatus status;
    private final String code;
    private final String message;
}
