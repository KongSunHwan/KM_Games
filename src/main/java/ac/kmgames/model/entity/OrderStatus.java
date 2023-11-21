package ac.kmgames.model.entity;

public enum OrderStatus {
    COMPLETED("주문완료"),  // 주문 완료
    CANCELED("주문취소");    // 주문 취소

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
