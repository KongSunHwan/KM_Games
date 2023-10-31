package ac.kmgames.model.dto;

import ac.kmgames.model.utils.PageVO;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class GameDTO extends PageVO {
    private long id;
    private String name;
    private String developer;
    private String genre;
    private String description;
    private int age;
    private int price;
    private String thumbUrl;

}
