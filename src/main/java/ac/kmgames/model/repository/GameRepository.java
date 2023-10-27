package ac.kmgames.model.repository;

import ac.kmgames.model.entity.Game;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface GameRepository extends PagingAndSortingRepository<Game, Long>{
    long count();

    Optional<Game> findById(long id);

    Page<Game> findByNameContains(String keyword, Pageable pageable);


}
