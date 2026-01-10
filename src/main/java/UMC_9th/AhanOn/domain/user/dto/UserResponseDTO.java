package UMC_9th.AhanOn.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class SignupResponse {
        private String nickname;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class LoginResponse {
        private String token;
        private String nickname;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class NicknameCheckResponse {
        private boolean isDuplicate;  // true: 중복, false: 사용 가능
        private String message;
    }
}
