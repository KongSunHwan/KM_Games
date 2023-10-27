package ac.kmgames.model.dto;

import lombok.Data;

@Data
public class PaymentHistoryDTO {
    private long id;
    private long user_id;
    private long game_id;
}
