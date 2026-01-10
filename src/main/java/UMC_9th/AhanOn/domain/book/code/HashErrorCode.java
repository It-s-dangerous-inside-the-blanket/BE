package UMC_9th.AhanOn.domain.book.code;

import UMC_9th.AhanOn.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum HashErrorCode implements BaseErrorCode {

    //Hashtag
    BAD_REQUEST_HASHTAG_EMPTY(HttpStatus.BAD_REQUEST, "HASHTAG_4001", "빈 해시태그입니다"),
    BAD_REQUEST_HASHTAG_NULL(HttpStatus.BAD_REQUEST, "HASHTAG_4002", "해시태그 값이 NULL입니다"),
    NOT_FOUND_HASHTAG(HttpStatus.NOT_FOUND, "HASHTAG4001", "존재하지 않는 해시태그입니다"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
