package UMC_9th.AhanOn.domain.book.exception;

import UMC_9th.AhanOn.global.apiPayload.code.BaseErrorCode;
import UMC_9th.AhanOn.global.apiPayload.exception.GeneralException;

public class BookException extends GeneralException {

    public BookException(BaseErrorCode code) {
        super(code);
    }
}
