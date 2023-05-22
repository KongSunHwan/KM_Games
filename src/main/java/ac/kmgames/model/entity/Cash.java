package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity(name = "cash_history")
@NoArgsConstructor
public class Cash{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int number;

    @Column
    private String email;

    @Column
    private int amount;

    @Column
    private String method;

    @Column(name = "payment_date")
    private Timestamp paymentDate;
}
