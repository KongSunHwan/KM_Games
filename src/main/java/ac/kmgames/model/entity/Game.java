package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Game{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String developer;

    @Column
    private String genre;

    @Column
    private String description;

    @Column
    private int age;

    @Column
    private int price;

    @Column(name = "thumb_url")
    private String thumbUrl;
}
