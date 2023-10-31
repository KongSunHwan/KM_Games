package ac.kmgames.service;

import ac.kmgames.model.dto.GameReviewDTO;
import ac.kmgames.model.entity.GameReview;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.mapper.GameMapper;
import ac.kmgames.model.mapper.GameReviewMapper;
import ac.kmgames.model.repository.GameReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
final public class GameReviewService{
    private final GameReviewRepository repository;
    private final GameReviewMapper gameReviewMapper;


    public long getCountByGameId(long id){
        return repository.countByGameId(id);
    }

    public List<GameReview> getAll(){
        return repository.findAll();
    }

    public List<GameReview> getAllByGameId(long id){
        return repository.findAllByGameId(id);
    }

    public float getAverageRateByGameId(long id){
        var list = getAllByGameId(id);
        if(list.isEmpty()){
            return 0;
        }

        float sum = 0;
        for(var review : list){
            sum += review.getRate();
        }
        return sum / list.size();
    }
    

    public boolean save(GameReview review){
        try{
            repository.save(review);
            return true;
        }catch(Exception ignored){
            ignored.printStackTrace();
            return false;
        }
    }

    public List<GameReview> findAllByUser(User selectUser) {
        return repository.findAllByUser(selectUser);
    }

    public List<HashMap> get_game_reivew_l5(long id) {
        return gameReviewMapper.get_game_reivew_l5(id);
    }
}
