package UMC_9th.AhanOn.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDTO {

    @Getter
    @NoArgsConstructor
    public static class SignupRequest {
        @NotBlank(message = "닉네임은 필수입니다.")
        private String nickname;
        @NotBlank(message = "비밀번호는 필수입니다.")
        private String password;
    }

    @Getter
    @NoArgsConstructor
    public static class LoginRequest {
        @NotBlank(message = "닉네임은 필수입니다.")
        private String nickname;
        @NotBlank(message = "비밀번호는 필수입니다.")
        private String password;
    }

    @Getter
    @NoArgsConstructor
    public static class NicknameCheckRequest {
        @NotBlank(message = "닉네임은 필수입니다.")
        private String nickname;
    }
}
