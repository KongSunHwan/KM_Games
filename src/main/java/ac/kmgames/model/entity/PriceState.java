package ac.kmgames.model.entity;

public enum PriceState {
    FREE("무료"),
    TRIAL("체험판");

    private final String description;

    PriceState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
