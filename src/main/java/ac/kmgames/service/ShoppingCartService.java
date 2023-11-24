package ac.kmgames.service;

import ac.kmgames.model.entity.*;
import ac.kmgames.model.repository.GameOrderRepository;
import ac.kmgames.model.repository.GamePostRepository;
import ac.kmgames.model.repository.ShoppingCartRepository;
import ac.kmgames.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final GamePostRepository gamePostRepository;
    private final GameOrderRepository orderRepository;

    // 쇼핑 카트에서 주문을 완료하고 주문 정보를 반환하는 메서드
//    public GameOrder checkout(Long cartId) {
//        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
//                .orElseThrow(() -> new IllegalArgumentException("쇼핑 카트를 찾을 수 없습니다: " + cartId));
//
//        GameOrder gameOrder = shoppingCart.checkout();
//        shoppingCartRepository.save(shoppingCart); // 쇼핑 카트 업데이트
//
//        return gameOrder;
//    }

    public void addToCart(Long userId, Long gameId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<GamePost> gamePostOptional = gamePostRepository.findById(gameId);

        if (userOptional.isPresent() && gamePostOptional.isPresent()) {
            User user = userOptional.get();
            GamePost gamePost = gamePostOptional.get();

            ShoppingCart shoppingCart = user.getShoppingCart();
            if (shoppingCart == null) {
                shoppingCart = new ShoppingCart();
                shoppingCart.setUser(user);
            }

            shoppingCart.addGameToCart(gamePost);
            shoppingCartRepository.save(shoppingCart);
        } else {
            throw new RuntimeException("사용자 또는 상품을 찾을 수 없습니다.");
        }
    }

    public void removeFromCart(Long userId, Long gameId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<GamePost> gamePostOptional = gamePostRepository.findById(gameId);

        if (userOptional.isPresent() && gamePostOptional.isPresent()) {
            User user = userOptional.get();
            GamePost gamePost = gamePostOptional.get();

            ShoppingCart shoppingCart = user.getShoppingCart();
            if (shoppingCart != null) {
                shoppingCart.removeGameFromCart(gamePost);
                shoppingCartRepository.save(shoppingCart);
            }
        } else {
            throw new RuntimeException("사용자 또는 상품을 찾을 수 없습니다.");
        }
    }

    // 사용자 ID로 쇼핑 카트 목록 가져오기
    public List<ShoppingCart> getShoppingCartByUser(Long userId) {
        // 구현: 사용자 ID로 쇼핑 카트 목록을 조회하는 로직
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return new ArrayList<>(user.getShoppingCarts());
        } else {
            return Collections.emptyList();
        }
    }

    // 게임을 쇼핑 카트에 추가
    public void addGameToCart(long gameId, long userId) {
        // 구현: 게임 ID로 게임 정보를 조회하고 쇼핑 카트에 추가하는 로직
        GamePost gamePost = gamePostRepository.findById(gameId).orElse(null);
        if (gamePost != null) {
            User user = getCurrentUser(userId); // 현재 사용자 정보 가져오기 (예시로 작성)
            ShoppingCart shoppingCart = user.getShoppingCart();
            shoppingCart.addGameToCart(gamePost);
            shoppingCartRepository.save(shoppingCart);
        }
    }

    // 쇼핑 카트에서 게임 제거
    public void removeGameFromCart(long gameId, long userId) {
        // 구현: 게임 ID로 쇼핑 카트에서 게임을 제거하는 로직
        GamePost gamePost = gamePostRepository.findById(gameId).orElse(null);
        if (gamePost != null) {
            User user = getCurrentUser(userId); // 현재 사용자 정보 가져오기 (예시로 작성)
            ShoppingCart shoppingCart = user.getShoppingCart();
            shoppingCart.removeGameFromCart(gamePost);
            shoppingCartRepository.save(shoppingCart);
        }
    }

    // 쇼핑 카트에서 게임 체크 여부 업데이트
    public void setGameItemChecked(long gameId, boolean isChecked, long userId) {
        // 구현: 게임 ID로 쇼핑 카트에서 게임의 체크 여부를 업데이트하는 로직
        GamePost gamePost = gamePostRepository.findById(gameId).orElse(null);
        if (gamePost != null) {
            User user = getCurrentUser(userId); // 현재 사용자 정보 가져오기 (예시로 작성)
            ShoppingCart shoppingCart = user.getShoppingCart();
            shoppingCart.setItemChecked(gamePost, isChecked);
            shoppingCartRepository.save(shoppingCart);
        }
    }

    // 선택된 아이템으로 주문 생성
    @Transactional
    public GameOrder orderSelectedItems(long userId) {
        User user = getCurrentUser(userId);
        ShoppingCart shoppingCart = user.getShoppingCart();
        List<GamePost> selectedItems = shoppingCart.getSelectedItems();

        if (!selectedItems.isEmpty()) {
            GameOrder order = new GameOrder();
            order.setUser(user);
            order.setShoppingCart(shoppingCart);
            order.setGamePosts(selectedItems);
            order.setTotalAmount(shoppingCart.calculateTotalPrice(selectedItems));
            order.setPaymentType(PaymentType.UNCHECKED_PAYMENT);
            order.setOrderStatus(OrderStatus.COMPLETED);

            shoppingCart.removeSelectedItems();
            shoppingCartRepository.save(shoppingCart);

            orderRepository.save(order);

            return order;
        } else {
            return null;
        }
    }

    // 사용자 정보를 가져오는 예시 메서드
    private User getCurrentUser(Long UserId) {
        return userRepository.findById(UserId).orElse(null);
    }

    public List<ShoppingCart> getShoppingCartListByUserId(Long UserId) {
        // 멤버 ID에 해당하는 쇼핑 카트 목록 조회
        return shoppingCartRepository.findByUserId(UserId);
    }

    // 쇼핑 카트 저장 메서드
    public void save(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }


}
