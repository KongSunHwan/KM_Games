package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity(name = "payment_history")
@NoArgsConstructor
public class Payment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    @OneToOne
    @JoinColumn(name="item_id")
    private Item item;

    @Column(insertable = false)
    private Timestamp date;
}
