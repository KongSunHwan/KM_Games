package ac.kmgames.model.repository;

import ac.kmgames.model.entity.ShoppingCart;
import ac.kmgames.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUser(User user);

    List<ShoppingCart> findByUserId(Long UserId);

}
