package ac.kmgames.model.repository;

import ac.kmgames.model.entity.CartItem;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findAll();

    @Query("SELECT COUNT(ci) FROM CartItem ci JOIN ci.shoppingCart sc WHERE ci.gamePost = :gamePost AND sc.user = :user And ci.isChecked = true")
    long countByGamePostAndUser(@Param("gamePost") Optional<GamePost> gamePost, @Param("user") User user);

    @Query("SELECT ci.isChecked FROM CartItem ci JOIN ci.shoppingCart sc WHERE ci.gamePost = :gamePost AND sc.user = :user")
    Boolean findIsCheckedByGamePostAndUser(@Param("gamePost") Optional<GamePost> gamePost, @Param("user") User user);

    @Query("SELECT ci.orderState FROM CartItem ci JOIN ci.shoppingCart sc WHERE ci.gamePost = :gamePost AND sc.user = :user")
    Integer findOrderStateByGamePostAndUser(@Param("gamePost") Optional<GamePost> gamePost, @Param("user") Optional<User> user);

}
