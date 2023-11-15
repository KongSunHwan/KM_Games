package ac.kmgames.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private long id;
    private String name;
    private String developer;
    private String genre;
    private String description;
    private int age;
    private int price;
    private String thumbUrl;

}
