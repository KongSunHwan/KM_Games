package ac.kmgames.model.repository;

import ac.kmgames.model.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{
    List<Payment> findAllByEmail(String email);
}
