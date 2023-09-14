package ac.kmgames.service;

import ac.kmgames.model.entity.Cash;
import ac.kmgames.model.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
final public class CashService{
    private final CashRepository repository;

    public CashService(@Autowired CashRepository repository){
        this.repository = repository;
    }

    public List<Cash> getHistoryListByEmail(String email, int page){
        return repository.findAllByUserEmail(
            email,
            PageRequest.of(page, 20, Sort.by("number").descending())
        );
    }

    public int getHistoryCountByEmail(String email){
        return repository.countAllByUserEmail(email);
    }

    public boolean save(Cash cash){
        try{
            repository.save(cash);
            return true;
        }catch(Exception ignored){
            return false;
        }
    }
}
