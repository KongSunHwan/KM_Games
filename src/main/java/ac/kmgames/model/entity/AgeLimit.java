package ac.kmgames.model.entity;

public enum AgeLimit {
    FREE("전체이용가"), // 전체 이용가
    TWOWELL("12세이상"), // 12세 이상
    FIFTEEN("15세이상"), // 15세 이상
    NINETEEN("19세이상"); // 19세 이상

    private final String description;

    AgeLimit(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
