package ac.kmgames.model.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CashHistoryDTO {
    private long id;
    private long user_id;
    private int amount;
    private String method;
    private Timestamp date;
}
