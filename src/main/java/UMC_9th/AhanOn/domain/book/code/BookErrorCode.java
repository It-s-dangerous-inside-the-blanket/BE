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
    NOT_ENDDED_BOOK(HttpStatus.BAD_REQUEST, "BOOK4002", "아직 완료되지 않은 책입니다."),
    NOT_OWNER_OF_BOOK(HttpStatus.UNAUTHORIZED, "BOOK4003", "책의 주인이 아닙니다")

;


    private final HttpStatus status;
    private final String code;
    private final String message;
}
