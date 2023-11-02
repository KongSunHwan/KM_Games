package ac.kmgames.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentHistoryDTO {
    private long id;
    private String name;
    private String genre;
    private String developer;
    private int price;
    private String date;
}
