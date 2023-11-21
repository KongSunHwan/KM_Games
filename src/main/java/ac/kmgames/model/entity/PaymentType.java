package ac.kmgames.model.entity;

public enum PaymentType {
    CARD("카드결제"),
    BANK_TRANSFER("실시간 계좌이체"),
    MOBILE_PAYMENT("휴대폰 결제"),
    BANK_DEPOSIT("무통장 입금"),
    ESCROW("가상계좌"),
    POINT_PAYMENT("포인트 결제"),
    UNCHECKED_PAYMENT("선택 안함");

    private final String description;

    PaymentType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
