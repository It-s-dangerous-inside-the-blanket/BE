package UMC_9th.AhanOn.domain.user.dto;

import UMC_9th.AhanOn.domain.user.entity.UserLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MyPageDTO {
        private LocalDate today;
        private Integer afterJoin;
        private Integer writeChapterCnt;
        private Integer writeBookCnt;
        private UserLevel userLevel;
    }
}
