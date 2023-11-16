package ac.kmgames.service;

import ac.kmgames.model.dto.ResponsePageDTO;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.GameReview;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.mapper.GameReviewMapper;
import ac.kmgames.model.repository.GamePostRepository;
import ac.kmgames.model.repository.GameReviewRepository;
import ac.kmgames.model.repository.UserRepository;
import ac.kmgames.model.utils.Criteria;
import ac.kmgames.model.utils.PageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameReviewService{
    private final GameReviewRepository repository;
    private final GameReviewMapper gameReviewMapper;
    private final GamePostRepository gamePostRepository;
    private final UserRepository userRepository;


    public long getCountByGamePostId(long id){
        return repository.countByGamePostId(id);
    }

    public List<GameReview> getAll(){
        return repository.findAll();
    }

//    public float getAverageRateByGamePostId(long id){
//        var list = getAllByGamePostId(id);
//        if(list.isEmpty()){
//            return 0;
//        }
//
//        float sum = 0;
//        for(var review : list){
//            sum += review.getRate();
//        }
//        return sum / list.size();
//    }
    

    public boolean save(GameReview review){
        try{
            repository.save(review);
            return true;
        }catch(Exception ignored){
            ignored.printStackTrace();
            return false;
        }
    }

    @Transactional
    public GameReview writeReview(GamePost gamePost, User user, int rating, String comment) {
        GameReview gameReview = new GameReview(gamePost, user, rating, comment);
        return repository.save(gameReview);
    }

    public void updateReview(Long reviewId, int newRating, String newComment) {
        Optional<GameReview> optionalReview = repository.findById(reviewId);

        if (optionalReview.isPresent()) {
            GameReview existingReview = optionalReview.get();
            existingReview.setRating(newRating);
            existingReview.setComment(newComment);
            repository.save(existingReview);

            updateReviewStatistics(existingReview.getGamePost());
        } else {
            // 리뷰를 찾을 수 없음에 대한 처리
        }
    }

    public void updateReviewStatistics(GamePost gamePost) {
        List<GameReview> reviews = repository.findByGamePost(gamePost);

        int totalRatingSum = 0;
        int totalReviewCount = reviews.size();

        for (GameReview review : reviews) {
            totalRatingSum += review.getRating();
        }

        double averageRating = (totalReviewCount > 0) ? ((double) totalRatingSum / totalReviewCount) : 0;

        // 반올림하여 설정합니다.
        int roundedRating = (int) Math.round(averageRating);

        // GamePost 엔터티의 transient 속성 업데이트
        gamePost.setAverageRating(averageRating);
        gamePost.setTotalReviews(totalReviewCount);
        gamePost.setRating(roundedRating);

        // GamePost 엔터티 업데이트
        gamePostRepository.save(gamePost);
    }

    public List<GameReview> getReviewsByGameId(long gameId) {
        return repository.findByGamePostId(gameId);
    }

    public List<GameReview> findAllByUser(User selectUser) {
        return repository.findAllByUser(selectUser);
    }

    public List<HashMap> get_game_reivew_l5(long id) {
        return gameReviewMapper.get_game_reivew_l5(id);
    }

    public ResponsePageDTO.ResponseReview get_review_group_game(Criteria criteria, long id) {
        Criteria cs = new Criteria(criteria.getPageNum(), criteria.getAmount(), criteria.getType(), criteria.getKeyword());
        List<HashMap> game_review = gameReviewMapper.getGameSearchList(cs,id);
        int total = gameReviewMapper.getGameSearchCount(cs,id);
        PageDTO pageDTO = new PageDTO(cs,total);
        return  new ResponsePageDTO.ResponseReview(game_review, pageDTO);
    }

}
