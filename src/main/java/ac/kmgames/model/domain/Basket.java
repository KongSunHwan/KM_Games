package ac.kmgames.model.domain;

import ac.kmgames.model.entity.Game;
import ac.kmgames.model.entity.User;
import lombok.Data;

@Data
class Basket {
    private long id;
    private long user_id;
    private long game_id;
}
