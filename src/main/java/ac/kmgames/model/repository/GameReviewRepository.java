package ac.kmgames.model.repository;

import ac.kmgames.model.entity.GameReview;

import java.util.List;

import ac.kmgames.model.entity.User;
import org.springframework.data.repository.Repository;

public interface GameReviewRepository extends Repository<GameReview, Long>{
    long countByGameId(long id);

    List<GameReview> findAll();
    List<GameReview> findAllByGameId(long id);
    List<GameReview> findAllByUser(User selectUser);
}
