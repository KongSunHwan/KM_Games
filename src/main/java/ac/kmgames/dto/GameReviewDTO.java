package ac.kmgames.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class GameReviewDTO {
    private long id;
    private String gameTitle;
    private String userEmail;
    private String comment;
    private int rate;
    private Timestamp date;
}
