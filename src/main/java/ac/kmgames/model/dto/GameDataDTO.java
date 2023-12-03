package ac.kmgames.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@Setter @Getter
public class GameDataDTO {
    private Integer gid;
    private String name;
    private Integer gcount;
    private Double y;
    private Integer gphid;
    private Integer gprice;

    public GameDataDTO(Integer gid, String name, Integer gcount, Double y, Integer gphid, Integer gprice) {
        this.gid = Objects.requireNonNullElse(gid, 0);
        this.name = name;
        this.gcount = Objects.requireNonNullElse(gcount, 0);
        this.y = Objects.requireNonNullElse(y, 0.00);
        this.gphid = Objects.requireNonNullElse(gphid, 0);
        this.gprice = Objects.requireNonNullElse(gprice, 0);
    }
}
