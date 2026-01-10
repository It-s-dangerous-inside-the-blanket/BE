package UMC_9th.AhanOn.domain.user.exception;

import UMC_9th.AhanOn.global.apiPayload.code.BaseErrorCode;
import UMC_9th.AhanOn.global.apiPayload.exception.GeneralException;

public class UserException extends GeneralException {
    public UserException(BaseErrorCode code) {
        super(code);
    }
}
