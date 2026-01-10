package UMC_9th.AhanOn.domain.user.code;

import UMC_9th.AhanOn.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserSuccessCode implements BaseSuccessCode {

    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}