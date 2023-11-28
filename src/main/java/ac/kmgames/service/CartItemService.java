package ac.kmgames.service;

import ac.kmgames.model.entity.CartItem;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.CartItemRepository;
import ac.kmgames.model.repository.GamePostRepository;
import ac.kmgames.model.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.nio.channels.Pipe;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final GamePostRepository gamePostRepository;
    private final UserRepository userRepository;

    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    public long countByGamePostAndUser(@Param("gamePost") Optional<GamePost> gamePost, @Param("user") User user) {
        return cartItemRepository.countByGamePostAndUser(gamePost, user);
    }

    // 게임 포스트 및 사용자에 대한 isChecked 값 가져오기
    public Boolean getIsCheckedValue(Long gameId, Long userId) {
        Optional<GamePost> gamePostOptional = gamePostRepository.findById(gameId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (gamePostOptional.isPresent() && userOptional.isPresent()) {
            GamePost gamePost = gamePostOptional.get();
            User user = userOptional.get();

            return cartItemRepository.findIsCheckedByGamePostAndUser(Optional.of(gamePost), user);
        } else {
            throw new RuntimeException("게임 포스트 또는 사용자를 찾을 수 없습니다.");
        }
    }

    public Integer findOrderStateByGamePostAndUser(GamePost gamePost, User user) {
        Optional<GamePost> gamePostOptional = Optional.ofNullable(gamePost);
        Optional<User> userOptional = Optional.ofNullable(user);

        return cartItemRepository.findOrderStateByGamePostAndUser(gamePostOptional, userOptional);
    }

}
