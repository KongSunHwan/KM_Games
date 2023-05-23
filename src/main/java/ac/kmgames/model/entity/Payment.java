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

    @Column
    private String email;

    @OneToOne
    @JoinColumn(name="item_id")
    private Item item;

    @Column(insertable = false)
    private Timestamp date;
}
