package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@Entity(name = "payment_history")
@NoArgsConstructor
public class PaymentHistory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @Column(insertable = false)
    private Timestamp date;
}
