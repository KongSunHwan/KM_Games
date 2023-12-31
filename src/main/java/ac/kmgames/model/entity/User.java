package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseTimeEntity{
    public static User NULL(){
        return new User(-1, "", "", "", "", 0, null, false, null, null, null, null);
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

    @Column
    private boolean ban;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<GameReview> gameReviews;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<CashHistory> cashHistories;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<PaymentHistory> paymentHistories;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<ShoppingCart> shoppingCarts;

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

    public ShoppingCart getShoppingCart() {
        // 쇼핑 카트를 반환하는 로직을 추가합니다.
        if (shoppingCarts != null && !shoppingCarts.isEmpty()) {
            return shoppingCarts.iterator().next();
        }
        return null;
    }
}
