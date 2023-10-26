package ac.kmgames.model.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
class Game {
    private long id;
    private long user_id;
    private int amount;
    private String method;
    private Timestamp date;

}
