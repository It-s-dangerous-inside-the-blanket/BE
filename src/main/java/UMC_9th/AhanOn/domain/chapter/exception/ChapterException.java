package UMC_9th.AhanOn.domain.chapter.exception;

import UMC_9th.AhanOn.global.apiPayload.code.BaseErrorCode;
import UMC_9th.AhanOn.global.apiPayload.exception.GeneralException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ChapterException extends GeneralException {
    public ChapterException(BaseErrorCode code) {
        super(code);
    }
}