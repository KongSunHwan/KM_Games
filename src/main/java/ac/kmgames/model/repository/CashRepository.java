package ac.kmgames.model.repository;

import ac.kmgames.model.entity.Cash;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CashRepository extends PagingAndSortingRepository<Cash, Integer>{
    List<Cash> findAllByEmailOrderByNumberDesc(String email, Pageable pageable);
}
