package ac.kmgames.service;

import ac.kmgames.model.entity.Game;
import ac.kmgames.model.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
final public class GameService{
    private final GameRepository repository;

    public GameService(@Autowired GameRepository repository){
        this.repository = repository;
    }

    public List<Game> getAll(int page){
        return repository.findAll(PageRequest.of(page, 16)).getContent();
    }

    public long getCount(){
        return repository.count();
    }
}
