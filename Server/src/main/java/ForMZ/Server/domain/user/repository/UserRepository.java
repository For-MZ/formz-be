package ForMZ.Server.domain.user.repository;

import ForMZ.Server.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
