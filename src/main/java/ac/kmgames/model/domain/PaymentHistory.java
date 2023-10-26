package ac.kmgames.model.domain;

import lombok.Data;

@Data
class PaymentHistory {
    private long id;
    private long user_id;
    private long game_id;
}
