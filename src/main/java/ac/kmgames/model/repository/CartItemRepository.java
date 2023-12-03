package ac.kmgames.model.repository;

import ac.kmgames.model.entity.CartItem;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("SELECT ci.gamePost FROM CartItem ci WHERE ci.shoppingCart.user.id = :userId AND ci.orderState = 2")
    Page<CartItem> findGamePostsByUserIdAndOrderState(@Param("userId") Long userId, Pageable pageable);

//    @Query("SELECT c FROM CartItem c WHERE c.shoppingCart.user.id = :userId AND c.shoppingCart.id = :cartId")
//    List<CartItem> findByShoppingCartUser_IdAndShoppingCartId(Long userId, Long cartId);

    @Query("SELECT c FROM CartItem c WHERE c.shoppingCart.user.id = :userId AND c.shoppingCart.id = :cartId")
    Page<CartItem> findByShoppingCartUser_IdAndShoppingCartId(@Param("userId") Long userId, @Param("cartId") Long cartId, Pageable pageable);

}
