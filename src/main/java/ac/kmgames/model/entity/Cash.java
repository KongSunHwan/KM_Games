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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    @Column
    private int amount;

    @Column
    private String method;

    @Column(name = "payment_date", insertable = false)
    private Timestamp paymentDate;
}
