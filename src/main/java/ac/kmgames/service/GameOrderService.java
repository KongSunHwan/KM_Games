package ac.kmgames.service;

import ac.kmgames.Exception.DuplicateOrderException;
import ac.kmgames.model.entity.*;
import ac.kmgames.model.repository.GameOrderRepository;
import ac.kmgames.model.repository.GamePostRepository;
import ac.kmgames.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameOrderService {
    private final GameOrderRepository gameOrderRepository;
    private final GamePostRepository gamePostRepository;
    private final UserRepository userRepository;

    public List<GameOrder> getAllGameOrders() {
        return gameOrderRepository.findAll();
    }

    public Optional<GameOrder> getGameOrderById(Long id) {
        return gameOrderRepository.findById(id);
    }

//    public GameOrder createGameOrder(Long gameId, Long userId, int totalAmount, PaymentType paymentType, OrderStatus orderStatus) {
//        // 이미 해당 게임과 사용자에 대한 주문이 있는지 확인
//        if (gameOrderRepository.existsByGamePostIdAndUserId(gameId, userId)) {
//            // 중복된 주문이 이미 존재하면 예외를 던집니다.
//            throw new DuplicateOrderException("이미 해당 게임과 사용자에 대한 주문이 존재합니다.");
//        }
//
//        Optional<User> userOptional = userRepository.findById(userId);
//        User user = userOptional.orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
//
//        Optional<GamePost> gamePostOptional = gamePostRepository.findById(gameId);
//        GamePost gamePost = gamePostOptional.orElseThrow(() -> new IllegalArgumentException("GamePost not found with id: " + gameId));
//
//        // GameOrder 객체 생성
//        GameOrder gameOrder = new GameOrder();
//        gameOrder.setUser(user); // 사용자 정보 설정
//        gameOrder.setGamePost(gamePost); // 게임 정보 설정
//        gameOrder.setTotalAmount(totalAmount); // 총 주문 금액 설정
//        gameOrder.setPaymentType(paymentType); // 결제 타입
//        gameOrder.setOrderStatus(orderStatus); // 주문 상태
//
//        // 생성된 주문 정보를 저장
//        return gameOrderRepository.save(gameOrder);
//    }

    // userId와 gameId로 주문을 조회하는 메서드
//    public List<GameOrder> getOrderByUserIdAndGamePostId(Long userId, Long gamePostId) {
//        return gameOrderRepository.findByUserIdAndGamePostId(userId, gamePostId);
//    }

    // 사용자 ID를 기반으로 주문 내역 정보를 가져오는 구현
//    public Page<GameOrder> findByUserIdWithGameInfo(Long userId, Pageable pageable) {
//        return gameOrderRepository.findByUserIdWithGameInfo(userId, pageable);
//    }

    public GameOrder processOrder(GameOrder order) {
        return gameOrderRepository.save(order);
    }

    // GameOrderService 또는 ShoppingCartService 내부에 getLastOrder 메서드 추가
    public GameOrder getLastOrder(long userId) {
        // 가장 최근에 생성된 주문을 조회하는 로직
        List<GameOrder> userOrders = gameOrderRepository.findUserOrders(userId, PageRequest.of(0, 1, Sort.by(Sort.Order.desc("createdDateTime"))));

        if (!userOrders.isEmpty()) {
            return userOrders.get(0);
        } else {
            return null;
        }
    }

}
