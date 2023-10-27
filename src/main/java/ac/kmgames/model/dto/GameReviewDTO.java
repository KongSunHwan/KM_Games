package ac.kmgames.model.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class GameReviewDTO {
    private long id;
    private long user_id;
    private long game_id;
    private Timestamp date;

}
