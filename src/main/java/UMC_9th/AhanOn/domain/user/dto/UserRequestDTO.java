package UMC_9th.AhanOn.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDTO {

    @Getter
    @NoArgsConstructor
    public static class SignupRequest {
        private String nickname;
        private String password;
    }

    @Getter
    @NoArgsConstructor
    public static class LoginRequest {
        private String nickname;
        private String password;
    }

    @Getter
    @NoArgsConstructor
    public static class NicknameCheckRequest {
        private String nickname;
    }
}
