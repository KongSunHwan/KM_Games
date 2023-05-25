package ac.kmgames.service;

import ac.kmgames.model.entity.Payment;
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

    public List<Payment> getHistoryListByEmail(String email, int page){
        return repository.findAllByUser_EmailOrderByNumberDesc(email, PageRequest.of(page * 10, (page + 1) * 10));
    }

    public int getHistoryCountByEmail(String email){
        return repository.countAllByUser_Email(email);
    }
}
