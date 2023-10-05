package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.repository.cdi.Eager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User{
    public static User NULL(){
        return new User(-1, "", "", "", "", 0, null, null, null, null);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NaturalId
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<GameReview> gameReviews;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<CashHistory> cashHistories;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<PaymentHistory> paymentHistories;

    public boolean isValid(){
        return id > 0 && email.length() > 4 && registerDate != null;
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
