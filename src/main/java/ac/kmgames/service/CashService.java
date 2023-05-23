package ac.kmgames.service;

import ac.kmgames.model.entity.Cash;
import ac.kmgames.model.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
final public class CashService{
    private final CashRepository repository;

    public CashService(@Autowired CashRepository repository) {
        this.repository = repository;
    }

    public List<Cash> getAllHistoryByEmail(String email){
        return repository.findAllByEmail(email);
    }
}
