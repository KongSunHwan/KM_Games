package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class GamePost{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
