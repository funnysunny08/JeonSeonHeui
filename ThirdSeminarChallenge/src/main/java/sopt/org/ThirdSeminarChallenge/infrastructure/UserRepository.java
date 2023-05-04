package sopt.org.ThirdSeminarChallenge.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.ThirdSeminarChallenge.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {
    void save(User user);
    User findUserById(Long id);
}
