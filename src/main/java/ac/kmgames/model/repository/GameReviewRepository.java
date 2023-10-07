package ac.kmgames.model.repository;

import ac.kmgames.model.entity.GameReview;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface GameReviewRepository extends Repository<GameReview, Long>{
    long countByGameId(long id);

    List<GameReview> findAll();
    List<GameReview> findAllByGameId(long id);
    List<GameReview> findAllByUserId(long id);

    GameReview save(GameReview user);
}
