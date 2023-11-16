package ac.kmgames.model.entity;

import java.util.Optional;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class GameReview extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_post_id")
    private GamePost gamePost; // 해당 리뷰가 속한 게임 정보

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 리뷰를 작성한 사용자 정보

    @Column(nullable = false)
    private int rating; // 별점

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment; // 리뷰 내용

    @Transient
    private double averageRating; // 평균 별점

    @Transient
    private int totalReviews; // 전체 리뷰

    public GameReview(GamePost gamePost, User user, int rating, String comment) {
        this.gamePost = gamePost;
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }
}
