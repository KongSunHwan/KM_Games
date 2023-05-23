package ac.kmgames.model.repository;

import ac.kmgames.model.entity.Payment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Integer>{
    List<Payment> findAllByEmailOrderByNumberDesc(String email, Pageable pageable);
}