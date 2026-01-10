package UMC_9th.AhanOn.domain.user.repository;

import UMC_9th.AhanOn.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 닉네임으로 사용자 조회
    Optional<User> findByNickname(String nickname);

    // 닉네임 중복 확인
    boolean existsByNickname(String nickname);
}
