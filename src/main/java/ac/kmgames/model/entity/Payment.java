package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
public class Payment{
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String email;

    @Column
    private int itemId;

    @Column
    private String details;

    @Column(insertable = false)
    private Timestamp date;

}