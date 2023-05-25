package ac.kmgames.model.repository;

import ac.kmgames.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer>{
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
