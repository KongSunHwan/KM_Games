package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class GameTag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_tags_id")
    private Long id;
    private String gaem_tags;
    @OneToMany(mappedBy = "gameTag")
    private List<GamePost> gamePosts = new ArrayList<>();

    public GameTag(Long id, String gaem_tags) {
        this.id = id;
        this.gaem_tags = gaem_tags;
    }
    public GameTag() {
    }
}
