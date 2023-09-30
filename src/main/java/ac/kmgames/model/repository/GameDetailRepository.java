package ac.kmgames.model.repository;

import ac.kmgames.model.entity.Game;
import ac.kmgames.model.entity.GameDetail;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameDetailRepository extends PagingAndSortingRepository<GameDetail, Integer>{
}
