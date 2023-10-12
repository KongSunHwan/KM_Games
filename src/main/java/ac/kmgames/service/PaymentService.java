package ac.kmgames.service;

import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
final public class PaymentService{
    private final PaymentRepository repository;

    public PaymentService(@Autowired PaymentRepository repository) {
        this.repository = repository;
    }

    public List<PaymentHistory> getAllByUserId(long id, int page){
        return repository.findAllByUserId(
            id,
            PageRequest.of(page, 20, Sort.by("id").descending())
        );
    }

    public int getCountByUserId(long id){
        return repository.countAllByUserId(id);
    }

    public List<PaymentHistory> findAllByUser(int page, User selectUser) {
        return repository.findAllByUser(selectUser);
    }

    public double getCount() {
        return repository.count();
    }

    public List<PaymentHistory> getAll(int page){
        return repository.findAllByOrderByDateDesc(PageRequest.of(page, 5));
    }


}
