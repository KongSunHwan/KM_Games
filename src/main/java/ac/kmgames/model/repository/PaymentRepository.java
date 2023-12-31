package ac.kmgames.model.repository;

import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PaymentRepository extends PagingAndSortingRepository<PaymentHistory, Integer>{
    long count();
    int countAllByUserId(long id);

    List<PaymentHistory> findAllByUser(User user);
    List<PaymentHistory> findAllByUserId(long id, Pageable pageable);
}