package ac.kmgames.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@Entity
@NoArgsConstructor
public class ShoppingCart extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // 쇼핑 카트 소유자

    @ManyToMany
    @JoinTable(name = "cart_games",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "game_post_id"))
    private List<GamePost> gamePosts = new ArrayList<>();  // 쇼핑 카트에 담긴 게임 목록

    private int totalItems;  // 쇼핑 카드에 담긴 총 아이템 수

    // 쇼핑 카트에 담긴 전체 게임 가격
    @Transient
    private int totalCartPrice;

    @OneToOne(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private GameOrder gameOrder;  // 주문 정보

    @Transient
    private boolean isChecked;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();


    public void addGameToCart(GamePost game) {
        if (!gamePosts.contains(game)) {
            gamePosts.add(game);
            totalItems++;
            totalCartPrice += game.getGamePrice();
            calculateTotalPrice(getSelectedItems());  // 총 가격 갱신
        }
    }

    public void removeGameFromCart(GamePost game) {
        if (gamePosts.contains(game)) {
            gamePosts.remove(game);
            totalItems--;
            totalCartPrice -= game.getGamePrice();
            calculateTotalPrice(getSelectedItems());  // 총 가격 갱신
        }
    }
//
//    // 주문을 완료하고 주문 정보를 설정하는 메서드
//    public GameOrder checkout() {
//        if (gameOrder == null) {
//            gameOrder = new GameOrder();
//            gameOrder.setUser(user);
//            gameOrder.setGamePosts(new ArrayList<>(gamePosts));
//            gameOrder.setTotalAmount(totalCartPrice);
//        }
//        return gameOrder;
//    }

//    private void calculateTotalPrice() {
//        int newTotalPrice = 0;
//        for (GamePost game : gamePosts) {
//            newTotalPrice += game.getGamePrice();
//        }
//        totalCartPrice = newTotalPrice;
//    }

//    // 선택된 아이템 목록 반환
//    public List<GamePost> getSelectedItems() {
//        List<GamePost> selectedItems = new ArrayList<>();
//        for (GamePost game : gamePosts) {
//            if (game.isSelected()) {
//                selectedItems.add(game);
//            }
//        }
//        return selectedItems;
//    }

//    // 선택된 아이템 수 반환
//    public int getSelectedItemCount() {
//        int count = 0;
//        for (GamePost game : gamePosts) {
//            if (game.isSelected()) {
//                count++;
//            }
//        }
//        return count;
//    }

//    // 선택된 아이템 주문 로직
//    public GameOrder orderSelectedItems() {
//        List<GamePost> selectedItems = getSelectedItems();
//        if (selectedItems.isEmpty()) {
//            // 선택된 아이템이 없을 경우 예외 처리 또는 특정 로직을 추가할 수 있습니다.
//            return null;
//        }
//
//        GameOrder order = new GameOrder();
//        order.setUser(user);
//        order.setGamePosts(new ArrayList<>(selectedItems));
//        order.setTotalAmount(calculateTotalPrice(selectedItems));
//
//        // 선택된 아이템들을 카트에서 제거
//        removeSelectedItems();
//
//        return order;
//    }

//    // 선택된 아이템들의 총 가격 계산
//    private int calculateTotalPrice(List<GamePost> selectedItems) {
//        int newTotalPrice = 0;
//        for (GamePost game : selectedItems) {
//            newTotalPrice += game.getGamePrice();
//        }
//        totalCartPrice -= newTotalPrice;
//        return newTotalPrice;
//    }
    public List<GamePost> getSelectedItems() {
        List<GamePost> selectedItems = new ArrayList<>();
        for (GamePost game : gamePosts) {
            if (game.isCheck()) {
                selectedItems.add(game);
            }
        }
        return selectedItems;
    }

    public int calculateTotalPrice(List<GamePost> selectedItems) {
        int newTotalPrice = 0;
        for (GamePost game : selectedItems) {
            newTotalPrice += game.getGamePrice();
        }
        totalCartPrice -= newTotalPrice;
        return newTotalPrice;
    }
    public void setItemChecked(GamePost game, boolean isChecked) {
        for (GamePost item : gamePosts) {
            if (item.equals(game)) {
                item.setIsChecked(isChecked);
                calculateTotalPrice(getSelectedItems()); // 체크 여부에 따라 총 가격 업데이트
                break;
            }
        }
    }

    public void removeSelectedItems() {
        List<GamePost> itemsToRemove = new ArrayList<>();
        for (GamePost game : gamePosts) {
            if (game.isCheck()) {
                itemsToRemove.add(game);
            }
        }
        gamePosts.removeAll(itemsToRemove);
        totalItems -= itemsToRemove.size();
        calculateTotalPrice(getSelectedItems()); // 총 가격 업데이트
    }

    public GameOrder orderSelectedItems() {
        List<GamePost> selectedItems = getSelectedItems();
        if (selectedItems.isEmpty()) {
            // 체크된 아이템이 없는 경우 예외 처리 또는 특정 로직 추가
            return null;
        }

        GameOrder order = new GameOrder();
        order.setUser(user);
        order.setGamePosts(new ArrayList<>(selectedItems));
        order.setTotalAmount(calculateTotalPrice(selectedItems));

        // 체크된 아이템을 쇼핑 카트에서 제거
        removeSelectedItems();

        return order;
    }

}
