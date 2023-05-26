package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Game{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column
    private String name;

    @Column
    private String url;

    @Column(name = "img_url")
    private String imageUrl;

    @Column
    private String description;
}
