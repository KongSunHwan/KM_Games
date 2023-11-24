package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class GameOrder extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 주문에 속한 유저

    @ManyToMany
    @JoinTable(name = "order_games",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "game_post_id"))
    private List<GamePost> gamePosts; // 주문에 포함된 게임 목록

    @Column(name = "total_amount", nullable = true)
    private int totalAmount; // 주문 총 가격

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 주문 상태

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType; // 결제 상태

    @OneToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart; // 쇼핑 카트 정보


}
