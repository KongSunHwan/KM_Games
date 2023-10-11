package ac.kmgames.model.repository;

import ac.kmgames.model.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    boolean existsByEmail(String email);

    User save(User user);

    long count();

    Optional<User> findByEmail(String email);
    List<User> findByNameContains(String name);
    List<User> findByNicknameContains(String nickname);

    Optional<User> findByNickname(String names);

    User findAllById(int id);

    List<User> getUsersByName(String id);
}
