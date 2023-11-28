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

import java.math.BigDecimal;
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

//    public void addToCart(Long userId, Long gameId) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        Optional<GamePost> gamePostOptional = gamePostRepository.findById(gameId);
//
//        if (userOptional.isPresent() && gamePostOptional.isPresent()) {
//            User user = userOptional.get();
//            GamePost gamePost = gamePostOptional.get();
//
//            ShoppingCart shoppingCart = user.getShoppingCart();
//            if (shoppingCart == null) {
//                shoppingCart = new ShoppingCart();
//                shoppingCart.setUser(user);
//            }
//
//            shoppingCart.addGameToCart(gamePost);
//            shoppingCartRepository.save(shoppingCart);
//        } else {
//            throw new RuntimeException("사용자 또는 상품을 찾을 수 없습니다.");
//        }
//    }

    public void addToCart(Long userId, Long gameId, boolean isChecked, int orderState) {
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

            // CartItem 추가 또는 업데이트
            CartItem cartItem = findCartItem(shoppingCart, gamePost);
            if (cartItem == null) {
                cartItem = new CartItem();
                cartItem.setShoppingCart(shoppingCart);
                cartItem.setGamePost(gamePost);
                shoppingCart.getCartItems().add(cartItem);
            }

            cartItem.setChecked(isChecked);
            cartItem.setOrderState(orderState); // 주문 상태 설정

            shoppingCartRepository.save(shoppingCart);
        } else {
            throw new RuntimeException("사용자 또는 상품을 찾을 수 없습니다.");
        }
    }

    public void removeFromCart(Long userId, Long gameId, boolean isChecked, int orderState) {
        // 사용자 ID에 해당하는 사용자 정보 조회
        Optional<User> userOptional = userRepository.findById(userId);

        // 게임 ID에 해당하는 게임 정보 조회
        Optional<GamePost> gamePostOptional = gamePostRepository.findById(gameId);

        // 사용자 정보와 게임 정보가 모두 존재하는지 확인
        if (userOptional.isPresent() && gamePostOptional.isPresent()) {
            User user = userOptional.get();
            GamePost gamePost = gamePostOptional.get();

            // 사용자의 쇼핑 카트 조회
            ShoppingCart shoppingCart = user.getShoppingCart();

            // 쇼핑 카트가 존재하면 해당 게임을 제거하고 isChecked 값을 false로 설정한 후 저장
            if (shoppingCart != null) {
                shoppingCart.removeGameFromCart(gamePost);

                // CartItem 업데이트
                CartItem cartItem = findCartItem(shoppingCart, gamePost);

                if (cartItem != null) {
                    cartItem.setChecked(isChecked);
                    cartItem.setOrderState(orderState); // 주문 상태 설정
                    shoppingCartRepository.save(shoppingCart);
                }

                shoppingCartRepository.save(shoppingCart);
            }
        } else {
            // 사용자 또는 상품을 찾을 수 없을 경우 예외 처리
            throw new RuntimeException("사용자 또는 상품을 찾을 수 없습니다.");
        }
    }

    public CartItem findCartItem(ShoppingCart shoppingCart, GamePost gamePost) {
        List<CartItem> cartItems = shoppingCart.getCartItems();

        for (CartItem cartItem : cartItems) {
            if (cartItem.getGamePost().equals(gamePost)) {
                return cartItem;
            }
        }
        return null;
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

    @Transactional
    public GameOrder orderSelectedItems(long userId) {
        // 현재 사용자 정보 가져오기
        User user = getCurrentUser(userId);

        // 사용자의 쇼핑 카트 가져오기
        ShoppingCart shoppingCart = user.getShoppingCart();
        List<GamePost> selectedItems = shoppingCart.getSelectedItems();

        // 선택된 상품이 있는지 확인
        if (!selectedItems.isEmpty()) {
            // 이미 주문이 있는지 확인
            GameOrder existingOrder = orderRepository.findByUserAndOrderStatus(user, OrderStatus.COMPLETED);

            if (existingOrder != null) {
                // 이미 주문이 있는 경우 해당 주문을 업데이트
                existingOrder.setGamePosts(selectedItems);

                // 총 가격 업데이트
                int totalAmount = shoppingCart.calculateTotalPrice(selectedItems);
                existingOrder.setTotalAmount(totalAmount);

                existingOrder.setPaymentType(PaymentType.UNCHECKED_PAYMENT);

                // 선택된 상품의 isChecked 필드를 null로 초기화하고 구매 상태로 설정
                for (CartItem cartItem : shoppingCart.getCartItems()) {
                    if (selectedItems.contains(cartItem.getGamePost())) {
                        cartItem.setChecked(false);
                        cartItem.setOrderState(2); // 이미 구매됨으로 설정
                    }
                }

                // 주문과 쇼핑 카트 업데이트
                orderRepository.save(existingOrder);
                shoppingCart.removeSelectedItems();
                shoppingCartRepository.save(shoppingCart);

                return existingOrder; // 업데이트된 주문 반환
            } else {
                // 주문이 없는 경우 새로운 주문 생성
                GameOrder newOrder = new GameOrder();
                newOrder.setUser(user);
                newOrder.setShoppingCart(shoppingCart);
                newOrder.setGamePosts(selectedItems);

                // 총 가격 설정
                int totalAmount = shoppingCart.calculateTotalPrice(selectedItems);
                newOrder.setTotalAmount(totalAmount);

                newOrder.setPaymentType(PaymentType.UNCHECKED_PAYMENT);
                newOrder.setOrderStatus(OrderStatus.COMPLETED);

                shoppingCart.removeSelectedItems();
                shoppingCartRepository.save(shoppingCart);

                orderRepository.save(newOrder);

                for (CartItem cartItem : shoppingCart.getCartItems()) {
                    if (selectedItems.contains(cartItem.getGamePost())) {
                        cartItem.setChecked(false);
                        cartItem.setOrderState(2); // 이미 구매됨으로 설정
                    }
                }

                return newOrder; // 새로 생성된 주문 반환
            }
        } else {
            return null; // 선택된 상품이 없는 경우 null 반환
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
