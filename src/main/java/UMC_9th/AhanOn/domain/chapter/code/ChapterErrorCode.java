package UMC_9th.AhanOn.domain.chapter.code;

import UMC_9th.AhanOn.global.apiPayload.code.BaseErrorCode;
import UMC_9th.AhanOn.global.apiPayload.code.GeneralErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.annotation.processing.Generated;


@Getter
@AllArgsConstructor
public enum ChapterErrorCode implements BaseErrorCode {

    WRONG_CHAPTER(HttpStatus.BAD_REQUEST, "CHAPTER400_1", "알 수 없는 챕터 id 에요"),

    VALID_FAIL(HttpStatus.BAD_REQUEST, "VALID400_1", "검증에 실패했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
