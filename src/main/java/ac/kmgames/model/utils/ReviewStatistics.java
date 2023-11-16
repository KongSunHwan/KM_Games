package ac.kmgames.model.utils;

import lombok.Data;

@Data
public class ReviewStatistics {
    private int fiveStarCount;
    private int fourStarCount;
    private int threeStarCount;
    private int twoStarCount;
    private int oneStarCount;
    private double averageRate;
    private int reviewCount;

    public int getFiveStarPercentage() {
        return calculateReviewPercentage(fiveStarCount);
    }

    public int getFourStarPercentage() {
        return calculateReviewPercentage(fourStarCount);
    }

    public int getThreeStarPercentage() {
        return calculateReviewPercentage(threeStarCount);
    }

    public int getTwoStarPercentage() {
        return calculateReviewPercentage(twoStarCount);
    }

    public int getOneStarPercentage() {
        return calculateReviewPercentage(oneStarCount);
    }

    public void calculateReviewCount() {
        // 리뷰 개수를 계산하는 로직
        this.reviewCount = fiveStarCount + fourStarCount + threeStarCount + twoStarCount + oneStarCount;
    }

    private int calculateReviewPercentage(int starCount) {
        int totalReviewCount = fiveStarCount + fourStarCount + threeStarCount + twoStarCount + oneStarCount;
        return totalReviewCount == 0 ? 0 : (starCount * 100) / totalReviewCount;
    }

    // 리뷰 총 개수 계산 메서드
    public int calculateTotalReviewCount() {
        return fiveStarCount + fourStarCount + threeStarCount + twoStarCount + oneStarCount;
    }

    // 리뷰 평균 평점 계산 메서드
    public void calculateAverageRate() {
        int totalRatingSum = (5 * fiveStarCount) + (4 * fourStarCount) + (3 * threeStarCount) + (2 * twoStarCount) + (1 * oneStarCount);
        int totalReviewCount = calculateTotalReviewCount();

        this.averageRate = (totalReviewCount > 0) ? ((double) totalRatingSum / totalReviewCount) : 0;

        String formattedAverageRate = String.format("%.1f", this.averageRate);

        this.averageRate = Double.parseDouble(formattedAverageRate);
    }
}
