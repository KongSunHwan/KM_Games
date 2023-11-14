package ac.kmgames.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter @Getter
public class GameSearch {

    private String gameTitle;
    private Set<String> gameTags;
}
