package ac.kmgames.model.repository;

import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.GameReview;

import java.util.List;
import java.util.Optional;

import ac.kmgames.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface GameReviewRepository extends Repository<GameReview, Long>{
    long countByGamePostId(long id);

    List<GameReview> findAll();
    List<GameReview> findAllByGamePostId(long id);
    List<GameReview> findAllByUserId(long id);

    GameReview save(GameReview user);

    List<GameReview> findAllByUser(User selectUser);

    // 특정 게임 게시물의 리뷰 목록을 가져오기
    List<GameReview> findByGamePostId(long id);

    // 특정 사용자의 리뷰 목록을 가져오기
    List<GameReview> findByUser(User user);

    List<GameReview> findByGamePost(GamePost gamePost);

    Optional<GameReview> findById(Long reviewId);

    List<GameReview> findAllByOrderByIdDesc();

    Page<GameReview> findAllByOrderByIdDesc(Pageable pageable);

    Page<GameReview> findAllByUserIdOrderByIdDesc(Long userId, Pageable pageable);
}
