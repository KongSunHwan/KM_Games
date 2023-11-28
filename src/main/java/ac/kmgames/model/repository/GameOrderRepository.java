package ac.kmgames.model.repository;

import ac.kmgames.model.entity.GameOrder;
import ac.kmgames.model.entity.OrderStatus;
import ac.kmgames.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GameOrderRepository extends JpaRepository<GameOrder, Long> {
    // 주문을 userId와 gameId로 조회하는 메서드
//    List<GameOrder> findByUserIdAndGamePostId(Long userId, Long gamePostId);

    // 해당 게임과 사용자에 대한 주문이 이미 존재하는지 확인하는 메서드
//    boolean existsByGamePostIdAndUserId(Long gamePostId, Long userId);

    // 특정 사용자의 주문 내역과 연관된 게임 정보를 페이지별로 가져오기
    @Query("SELECT go FROM GameOrder go JOIN go.gamePosts gp WHERE go.user.id = :userId ORDER BY go.id DESC")
    Page<GameOrder> findByUserIdWithGameInfo(@Param("userId") Long userId, Pageable pageable);

    GameOrder findByUserAndOrderStatus(User user, OrderStatus orderStatus);

    @Query("SELECT o FROM GameOrder o WHERE o.user.id = :userId ORDER BY o.createdDateTime DESC")
    List<GameOrder> findUserOrders(@Param("userId") long userId, Pageable pageable);

}
