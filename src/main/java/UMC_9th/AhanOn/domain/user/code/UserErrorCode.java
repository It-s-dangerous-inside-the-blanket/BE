package UMC_9th.AhanOn.domain.user.code;

import UMC_9th.AhanOn.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements BaseErrorCode {

    DUPLICATE_NICKNAME(HttpStatus.BAD_REQUEST, "USER4001", "이미 존재하는 닉네임입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER4004", "존재하지 않는 사용자입니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "USER4002", "비밀번호가 일치하지 않습니다."),

    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
