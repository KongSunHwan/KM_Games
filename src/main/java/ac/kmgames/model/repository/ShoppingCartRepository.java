package ac.kmgames.model.repository;

import ac.kmgames.model.entity.ShoppingCart;
import ac.kmgames.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUser(User user);

    List<ShoppingCart> findByUserId(Long UserId);

    @Query("SELECT s.id FROM ShoppingCart s WHERE s.user.id = :userId")
    Long findIdByUserId(@Param("userId") Long userId);
}
