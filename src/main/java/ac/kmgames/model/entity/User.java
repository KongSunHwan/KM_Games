package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String nickname;

    @Column
    private int cash;

    @Column(name = "register_date", insertable = false)
    private Timestamp registerDate;

    public void addCash(int amount){
        if(amount <= 0){
            return;
        }
        cash += amount;
    }

    public boolean subtractCash(int amount){
        if(amount <= 0){
            addCash(-amount);
            return true;
        }

        if(cash < amount){
            return false;
        }
        cash -= amount;
        return true;
    }
}
