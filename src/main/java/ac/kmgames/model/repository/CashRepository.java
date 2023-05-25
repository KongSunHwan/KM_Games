package ac.kmgames.model.repository;

import ac.kmgames.model.entity.Cash;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CashRepository extends PagingAndSortingRepository<Cash, Integer>{
    List<Cash> findAllByUser_EmailOrderByNumberDesc(@Param("userEmail") String email, Pageable pageable);
}
