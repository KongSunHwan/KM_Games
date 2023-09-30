package ac.kmgames.model.repository;

import ac.kmgames.model.entity.PaymentHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends PagingAndSortingRepository<PaymentHistory, Integer>{
    int countAllByUserEmail(@Param("userEmail") String email);

    List<PaymentHistory> findAllByUserEmail(@Param("userEmail") String email, Pageable pageable);
}