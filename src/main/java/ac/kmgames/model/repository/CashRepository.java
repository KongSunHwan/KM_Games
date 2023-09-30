package ac.kmgames.model.repository;

import ac.kmgames.model.entity.CashHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CashRepository extends PagingAndSortingRepository<CashHistory, Integer>, CrudRepository<CashHistory, Integer>{
    int countAllByUserEmail(@Param("userEmail") String email);

    List<CashHistory> findAllByUserEmail(@Param("userEmail") String email, Pageable pageable);
}
