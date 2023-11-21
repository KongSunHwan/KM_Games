package ac.kmgames.model.dto;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.OrderStatus;
import ac.kmgames.model.entity.PaymentType;
import ac.kmgames.model.entity.User;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
public class GameOrderDTO {
    private Long id;
    private User user;
    private GamePost gamePost;
    private int totalAmount;
    private OrderStatus orderStatus;
    private PaymentType paymentType;
}
