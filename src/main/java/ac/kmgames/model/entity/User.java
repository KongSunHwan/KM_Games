package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User{
    public final static User NULL = new User(-1, "", "", "", "", 0, null);
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

    public boolean isValid(){
        return number > 0 && email.length() > 4 && registerDate != null;
    }

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
