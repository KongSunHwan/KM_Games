package ac.kmgames.service;

import ac.kmgames.model.entity.GameReview;
import ac.kmgames.model.utils.ReviewStatistics;

import java.util.List;

public class ReviewStatisticsService {

    private final GameReviewService gameReviewService;

    public ReviewStatisticsService(GameReviewService gameReviewService) {
        this.gameReviewService = gameReviewService;
    }

    public ReviewStatistics calculateReviewStatistics(long gameId) {
        List<GameReview> reviews = gameReviewService.getReviewsByGameId(gameId);

        int totalReviews = reviews.size();
        int totalRatingSum = reviews.stream().mapToInt(GameReview::getRating).sum();

        double averageRating = (totalReviews > 0) ? ((double) totalRatingSum / totalReviews) : 0;

        ReviewStatistics statistics = new ReviewStatistics();
        statistics.setAverageRate(averageRating);

        return statistics;
    }
}
