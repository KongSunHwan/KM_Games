package ac.kmgames.service;

import ac.kmgames.dto.GameReviewDTO;
import ac.kmgames.model.entity.Game;
import ac.kmgames.model.entity.GameReview;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.GameReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
final public class GameReviewService{
    private final GameReviewRepository repository;

    public GameReviewService(@Autowired GameReviewRepository repository){
        this.repository = repository;
    }

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

    public List<GameReviewDTO> getAllGameReviewsDTO() {
        List<GameReview> gameReviews = repository.findAll(); // 또는 다른 방식으로 게임 리뷰 목록을 가져옴

        List<GameReviewDTO> gameReviewDTOs = new ArrayList<>();
        for (GameReview review : gameReviews) {
            GameReviewDTO dto = new GameReviewDTO();
            dto.setId(review.getId());
            dto.setGameTitle(review.getGame().getName()); // 게임 제목 가져오기
            dto.setUserEmail(review.getUser().getEmail()); // 사용자 이메일 가져오기
            dto.setComment(review.getComment());
            dto.setRate(review.getRate());
            dto.setDate(review.getDate());
            gameReviewDTOs.add(dto);
        }

        return gameReviewDTOs;
    }
}
