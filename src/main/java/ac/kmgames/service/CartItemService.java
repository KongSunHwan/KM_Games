package ac.kmgames.service;

import ac.kmgames.model.entity.CartItem;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.CartItemRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    public long countByGamePostAndUser(@Param("gamePost") Optional<GamePost> gamePost, @Param("user") User user) {
        return cartItemRepository.countByGamePostAndUser(gamePost, user);
    }
}
