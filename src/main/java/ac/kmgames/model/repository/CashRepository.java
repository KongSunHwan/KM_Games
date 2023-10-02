package ac.kmgames.model.repository;

import ac.kmgames.model.entity.CashHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CashRepository extends PagingAndSortingRepository<CashHistory, Long>, CrudRepository<CashHistory, Long>{
    int countAllByUserEmail(@Param("userEmail") String email);

    List<CashHistory> findAllByUserId(long id);
    List<CashHistory> findAllByUserEmail(@Param("userEmail") String email, Pageable pageable);
}
