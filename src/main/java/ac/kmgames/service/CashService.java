package ac.kmgames.service;

import ac.kmgames.model.entity.CashHistory;
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

    public List<CashHistory> getAllByUserId(long id, int page){
        return repository.findAllByUserId(
            id,
            PageRequest.of(page, 20, Sort.by("id").descending())
        );
    }

    public int getCountByUserId(long id){
        return repository.countAllByUserId(id);
    }

    public boolean save(CashHistory cash){
        try{
            repository.save(cash);
            return true;
        }catch(Exception ignored){
            return false;
        }
    }
}
