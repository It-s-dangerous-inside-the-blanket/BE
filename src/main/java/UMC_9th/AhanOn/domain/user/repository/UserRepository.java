package UMC_9th.AhanOn.domain.user.repository;

import UMC_9th.AhanOn.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
