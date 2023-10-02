package ac.kmgames.model.repository;

import ac.kmgames.model.entity.Game;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameRepository extends PagingAndSortingRepository<Game, Long>{
    long count();
}
