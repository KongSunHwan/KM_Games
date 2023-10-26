package ac.kmgames.model.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
class GameReview {
    private long id;
    private long user_id;
    private long game_id;
    private Timestamp date;

}
