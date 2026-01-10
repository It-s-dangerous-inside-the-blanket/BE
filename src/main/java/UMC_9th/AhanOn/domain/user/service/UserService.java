package UMC_9th.AhanOn.domain.user.service;

import UMC_9th.AhanOn.domain.user.code.UserErrorCode;
import UMC_9th.AhanOn.domain.user.dto.UserRequestDTO;
import UMC_9th.AhanOn.domain.user.dto.UserResponseDTO;
import UMC_9th.AhanOn.domain.user.entity.User;
import UMC_9th.AhanOn.domain.user.entity.UserLevel;
import UMC_9th.AhanOn.domain.user.exception.UserException;
import UMC_9th.AhanOn.domain.user.repository.UserRepository;
import UMC_9th.AhanOn.global.validation.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // 회원가입
    @Transactional
    public UserResponseDTO.SignupResponse signup(UserRequestDTO.SignupRequest request) {
        // 닉네임 중복 확인
        if (userRepository.existsByNickname(request.getNickname())) {
            throw new UserException(UserErrorCode.DUPLICATE_NICKNAME);
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // User 엔티티 생성 및 저장
        User user = User.builder()
                .nickname(request.getNickname())
                .password(encodedPassword)
                .build();

        userRepository.save(user);

        return UserResponseDTO.SignupResponse.builder()
                .nickname(user.getNickname())
                .build();
    }

    // 로그인
    public UserResponseDTO.LoginResponse login(UserRequestDTO.LoginRequest request) {
        // 사용자 조회
        User user = userRepository.findByNickname(request.getNickname())
                .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));

        // 비밀번호 검증
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UserException(UserErrorCode.INVALID_PASSWORD);
        }

        // JWT 토큰 생성
        String token = jwtUtil.generateToken(user.getId());

        return UserResponseDTO.LoginResponse.builder()
                .token(token)
                .nickname(user.getNickname())
                .build();
    }

    // 닉네임 중복 확인
    public UserResponseDTO.NicknameCheckResponse checkNickname(String nickname) {
        boolean isDuplicate = userRepository.existsByNickname(nickname);

        String message = isDuplicate
                ? "이미 사용 중인 닉네임입니다."
                : "사용 가능한 닉네임입니다.";

        return UserResponseDTO.NicknameCheckResponse.builder()
                .isDuplicate(isDuplicate)
                .message(message)
                .build();
    }

    @Transactional
    public UserResponseDTO.MyPageDTO getMyPage(String nickname) {
        User user = userRepository.findByNickname(nickname)
                .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));


        // user -> bookList -> chapterList
        // user가 작성한 모든 책에 대한 챕터의 개수 어떻게 조회?
        int writeChapterCnt = user.getBookList().stream()
                .mapToInt(book -> book.getChapterList().size())
                .sum();


        // after join 어떻게 계싼?

        return UserResponseDTO.MyPageDTO.builder()
                .today(LocalDate.from(LocalDateTime.now()))
                .afterJoin((int)ChronoUnit.DAYS.between(user.getCreatedAt(), LocalDateTime.now()))
                .writeChapterCnt(writeChapterCnt)
                .writeBookCnt(user.getCompletedBookCount())
                .userLevel(UserLevel.fromBookCount(user.getCompletedBookCount()))
                .build();

    }
}