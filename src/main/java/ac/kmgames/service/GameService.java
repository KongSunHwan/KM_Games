package ac.kmgames.service;

import ac.kmgames.model.entity.Game;
import ac.kmgames.model.repository.GameDetailRepository;
import ac.kmgames.model.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
final public class GameService{
    private final GameRepository repository;
    private final GameDetailRepository detailrepository;

    @Autowired
    public GameService(GameRepository repository, GameDetailRepository detailrepository){
        this.repository = repository;
        this.detailrepository = detailrepository;
    }

    public List<Game> getGameList(){
        return repository.findAll(PageRequest.of(0, 4)).getContent();
    }
}
