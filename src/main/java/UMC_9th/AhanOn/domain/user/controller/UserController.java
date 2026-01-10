package UMC_9th.AhanOn.domain.user.controller;

import UMC_9th.AhanOn.domain.user.dto.UserRequestDTO;
import UMC_9th.AhanOn.domain.user.dto.UserResponseDTO;
import UMC_9th.AhanOn.domain.user.service.UserService;
import UMC_9th.AhanOn.global.apiPayload.ApiResponse;
import UMC_9th.AhanOn.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Tag(name = "인증 API", description = "회원가입, 로그인, 닉네임 중복 확인 API")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입", description = "닉네임과 비밀번호로 회원가입을 진행합니다.")
    @PostMapping("/signup")
    public ApiResponse<UserResponseDTO.SignupResponse> signup(
            @RequestBody UserRequestDTO.SignupRequest request
    ) {
        UserResponseDTO.SignupResponse response = userService.signup(request);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, response);
    }

    @Operation(summary = "로그인", description = "닉네임과 비밀번호로 로그인하여 JWT 토큰을 발급받습니다.")
    @PostMapping("login")
    public ApiResponse<UserResponseDTO.LoginResponse> login(
            @RequestBody UserRequestDTO.LoginRequest request
    ) {
        UserResponseDTO.LoginResponse response = userService.login(request);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, response);
    }

    @Operation(summary = "닉네임 중복 확인", description = "회원가입 시 닉네임 중복 여부를 확인합니다.")
    @GetMapping("/check-nickname")
    public ApiResponse<UserResponseDTO.NicknameCheckResponse> checkNickname(
            @RequestParam String nickname
    ) {
        UserResponseDTO.NicknameCheckResponse response = userService.checkNickname(nickname);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, response);
    }
}
