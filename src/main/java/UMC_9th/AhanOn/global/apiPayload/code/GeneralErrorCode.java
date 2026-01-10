package UMC_9th.AhanOn.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralErrorCode implements BaseErrorCode {

    // Common
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400_1", "잘못된 요청입니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON404_1", "요청한 리소스를 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "COMMON405_1", "허용되지 않은 요청 방식입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500_1", "예기치 않은 서버 에러가 발생했습니다."),

    // Auth
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "AUTH401_1", "인증이 필요합니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "AUTH403_1", "요청이 거부되었습니다."),

    // Validation
    VALID_FAIL(HttpStatus.BAD_REQUEST, "VALID400_1", "검증에 실패했습니다."),

    //BOOK
    NOT_FOUND_BOOK(HttpStatus.NOT_FOUND, "BOOK4001", "존재하지 않는 책입니다"),

    //Hashtag
    BAD_REQUEST_HASHTAG_EMPTY(HttpStatus.BAD_REQUEST, "HASHTAG_4001", "빈 해시태그입니다"),
    BAD_REQUEST_HASHTAG_NULL(HttpStatus.BAD_REQUEST, "HASHTAG_4002", "해시태그 값이 NULL입니다"),
    NOT_FOUND_HASHTAG(HttpStatus.NOT_FOUND, "HASHTAG4001", "존재하지 않는 해시태그입니다"),


    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}