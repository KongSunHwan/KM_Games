package ac.kmgames.service;

import ac.kmgames.model.entity.CartItem;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.ShoppingCart;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.CartItemRepository;
import ac.kmgames.model.repository.GamePostRepository;
import ac.kmgames.model.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    // 페이징된 게임 정보 가져오는 메서드
    public Page<CartItem> getGamePostsByUserIdAndOrderState(Long userId, Pageable pageable) {
        return cartItemRepository.findGamePostsByUserIdAndOrderState(userId, pageable);
    }

//    public List<GamePost> getGamesByMemberAndCart(Long memberId, Long cartId) {
//        List<CartItem> cartItems = cartItemRepository.findByShoppingCartUser_IdAndShoppingCartId(memberId, cartId);
//
//        // 게임 정보를 담을 리스트
//        List<GamePost> games = new ArrayList<>();
//
//        // 카트 아이템에서 게임 정보 추출
//        for (CartItem cartItem : cartItems) {
//            GamePost gamePost = cartItem.getGamePost();
//            games.add(gamePost);
//        }
//
//        return games;
//    }

    public Page<GamePost> getGamesByMemberAndCartWithPaging(Long memberId, Long cartId, Pageable pageable) {
        Page<CartItem> cartItemPage = cartItemRepository.findByShoppingCartUser_IdAndShoppingCartId(memberId, cartId, pageable);

        // Page에서 CartItem 리스트를 가져와서 GamePost로 변환
        List<GamePost> games = new ArrayList<>();
        List<CartItem> cartItems = cartItemPage.getContent();
        for (CartItem cartItem : cartItems) {
            GamePost gamePost = cartItem.getGamePost();
            games.add(gamePost);
        }

        // 게임 정보와 페이징 정보를 포함하는 Page 반환
        return new PageImpl<>(games, pageable, cartItemPage.getTotalElements());
    }

}
