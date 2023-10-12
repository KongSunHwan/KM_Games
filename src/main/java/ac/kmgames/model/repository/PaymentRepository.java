package ac.kmgames.model.repository;

import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PaymentRepository extends PagingAndSortingRepository<PaymentHistory, Integer>{
    int countAllByUserId(long id);
    
    List<PaymentHistory> findAllByUserId(long id, Pageable pageable);

    List<PaymentHistory> findAdminByUserId(long id);

    List<PaymentHistory> findAllByUser(User user);

    long count();

    List<PaymentHistory> findAllByOrderByDateDesc(PageRequest of);

}