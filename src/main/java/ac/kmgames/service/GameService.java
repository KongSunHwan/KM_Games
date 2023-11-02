package ac.kmgames.service;

import ac.kmgames.model.dto.GameDTO;
import ac.kmgames.model.dto.ResponsePageDTO;
import ac.kmgames.model.dto.UserDTO;
import ac.kmgames.model.entity.Game;
import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.mapper.GameMapper;
import ac.kmgames.model.repository.GameRepository;
import ac.kmgames.model.utils.Criteria;
import ac.kmgames.model.utils.PageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
final public class GameService{

    private final GameRepository repository;
    private final GameMapper gameMapper;

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

    public ResponsePageDTO.ResponseGame getGameListAdmin(Criteria criteria) {

        if(criteria.getKeyword() != null){
            Criteria cs = new Criteria(criteria.getPageNum(), 16, criteria.getType(), criteria.getKeyword());
            List<GameDTO> pageList = gameMapper.getGameSearchList(cs);
            int total = gameMapper.getGameSearchCount(cs);
            PageDTO pageDTO = new PageDTO(cs,total);
            return  new ResponsePageDTO.ResponseGame(pageList, pageDTO);

        } else {
            Criteria cs = new Criteria(criteria.getPageNum(), 16, criteria.getType(), criteria.getKeyword());
            List<GameDTO> pageList = gameMapper.getGameListAdmin(cs);
            int total = gameMapper.getCount(cs);
            PageDTO pageDTO = new PageDTO(cs,total);
            return  new ResponsePageDTO.ResponseGame(pageList, pageDTO);
        }
    }

    public List<GameDTO> get_game_info(long id) {
        return gameMapper.get_game_info(id);
    }
}
