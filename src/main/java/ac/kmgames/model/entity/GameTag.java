package ac.kmgames.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class GameTag {
    @Id @GeneratedValue
    private Long id;
    private String gaem_tags;

    public GameTag(Long id, String gaem_tags) {
        this.id = id;
        this.gaem_tags = gaem_tags;
    }
    public GameTag() {
    }
}
