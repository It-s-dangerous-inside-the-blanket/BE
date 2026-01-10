package UMC_9th.AhanOn.domain.chapter.code;

import UMC_9th.AhanOn.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ChapterSuccessCode implements BaseSuccessCode {

    CREATE_CHAPTER_SUCCESS(HttpStatus.OK, "CHAPTER200_1", "챕터 생성이 처리되었습니다."),
    DELETE_CHAPTER_SUCCESS(HttpStatus.OK, "CHAPTER200_2", "챕터 삭제가 처리되었습니다."),
    UPDATE_CHAPTER_SUCCESS(HttpStatus.OK, "CHAPTER200_3", "챕터 수정이 처리되었습니다."),
    GET_CHAPTER_SUCCESS(HttpStatus.OK, "CHAPTER200_4", "챕터 조회가 처리되었습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
