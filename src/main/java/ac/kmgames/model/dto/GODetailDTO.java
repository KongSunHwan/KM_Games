package ac.kmgames.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GODetailDTO {
    private int orderId;
    private String gameTitle;
    private String gamePrice;
    private String orderDate;
    private int gamePostId;
}
