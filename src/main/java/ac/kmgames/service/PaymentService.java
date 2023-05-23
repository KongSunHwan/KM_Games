package ac.kmgames.service;

import ac.kmgames.model.entity.Payment;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
final public class PaymentService{
    private final PaymentRepository repository;

    public PaymentService(@Autowired PaymentRepository repository) {
        this.repository = repository;
    }

    public List<Payment> getAllHistoryByEmail(String email, int page){
        return repository.findAllByEmailOrderByNumberDesc(email, PageRequest.of((page - 1) * 10, page * 10));
    }
}
