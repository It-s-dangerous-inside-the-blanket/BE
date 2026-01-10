package UMC_9th.AhanOn.domain.book.exception;

import UMC_9th.AhanOn.domain.book.entity.Hashtag;
import UMC_9th.AhanOn.global.apiPayload.code.BaseErrorCode;
import UMC_9th.AhanOn.global.apiPayload.exception.GeneralException;

public class HashtagException extends GeneralException {
    public HashtagException(BaseErrorCode code) {
        super(code);
    }
}
