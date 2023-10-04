package ac.kmgames.model.repository;

import ac.kmgames.model.entity.PaymentHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PaymentRepository extends PagingAndSortingRepository<PaymentHistory, Long>{
    int countAllByUserId(long id);
    
    List<PaymentHistory> findAllByUserId(long id, Pageable pageable);

    List<PaymentHistory> findAdminByUserId(long id);
}