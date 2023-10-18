package ac.kmgames.service;

import ac.kmgames.model.entity.Game;
import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
final public class GameService{
    private final GameRepository repository;

    public GameService(@Autowired GameRepository repository){
        this.repository = repository;
    }

    public List<Game> getAll(int page){
        return repository.findAll(PageRequest.of(page, 16)).getContent();
    }

    public Optional<Game> getGameById(long id){
        return repository.findById(id);
    }

    public long getCount(){
        return repository.count();
    }

    public Page<Game> getFindByName(String keyword, Pageable pageable) {
        return repository.findByNameContains(keyword,pageable);
    }
}
