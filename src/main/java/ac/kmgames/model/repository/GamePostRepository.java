package ac.kmgames.model.repository;


import ac.kmgames.model.entity.GamePhoto;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.GameReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GamePostRepository extends JpaRepository<GamePost, Long> {

    GamePost save(GamePost gamePost);

    List<GamePost> findAllByOrderByIdDesc();

}
