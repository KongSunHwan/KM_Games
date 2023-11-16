package ac.kmgames.model.dto;

import lombok.Data;

@Data
public class MonthlyTrafficDTO {
    private String month;
    private int games;
    private int members;
    private int plays;
    private int sales;
}