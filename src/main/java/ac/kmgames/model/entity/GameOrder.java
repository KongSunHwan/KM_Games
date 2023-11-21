package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter @Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"game_post_id", "user_id"})})
public class GameOrder extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 주문에 속한 유저

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_post_id", nullable = false)
    private GamePost gamePost;  // 주문에 속한 게임

    @Column(name = "total_amount", nullable = true)
    private int totalAmount; // 주문 총 가격

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 주문 상태

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType; // 결제 상태
}
