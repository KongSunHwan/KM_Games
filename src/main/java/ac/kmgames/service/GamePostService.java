package ac.kmgames.service;

import ac.kmgames.model.dto.GamePostDTO;
import ac.kmgames.model.entity.GamePhoto;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.entity.PriceState;
import ac.kmgames.model.mapper.GamePostMapper;
import ac.kmgames.model.repository.GamePhotoRepository;
import ac.kmgames.model.repository.GamePostRepository;
import ac.kmgames.model.utils.FileUtilities;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
public class GamePostService {
    private final GamePostRepository gamePostRepository;
    private final GamePhotoRepository gamePhotoRepository;
    private final GameReviewService gameReviewService;
    private final GamePostMapper gamePostMapper;


    public boolean save(GamePost gamePost){
        try{
            gamePostRepository.save(gamePost);
            return true;
        } catch(Exception ignored){
            return false;
        }
    }

    @Transactional(readOnly = true)
    public GamePostDTO.Response searchById(Long id) {
        GamePost entity = gamePostRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return new GamePostDTO.Response(entity);
    }

    @Transactional(readOnly = true)
    public List<GamePostDTO.ListResponse> searchAllDesc() {
        return gamePostRepository.findAllByOrderByIdDesc().stream()
                .map(GamePostDTO.ListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        GamePost gamePost = gamePostRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        gamePostRepository.delete(gamePost);
    }

    @Transactional
    public Long save(GamePost gamePost, List<MultipartFile> files, List<Long> deleteFileList) throws Exception {
        GamePost saveGamePost = getGamePostRepository().save(gamePost);
        List<GamePhoto> gamePhotosList = FileUtilities.parseFileInfo(files, saveGamePost);
        // 파일이 존재할 경우
        if (!gamePhotosList.isEmpty()) {
            gamePhotoRepository.saveAll(gamePhotosList);
        }
        // 삭제할 파일이 존재할 경우
        if (!deleteFileList.isEmpty()) {
            gamePhotoRepository.deleteByGamePhotoIdList(deleteFileList);
        }
        return saveGamePost.getId();
    }

    public Page<GamePost> findAllByOrderByIdDesc(Pageable pageable){

        Page<GamePost> page = gamePostRepository.findAllByOrderByIdDesc(pageable);

        // 각 게임의 리뷰 통계 업데이트
        for (GamePost gamePost : page.getContent()) {
            gameReviewService.updateReviewStatistics(gamePost);
        }

        return page;
    }

    public List<GamePost> findGamePostAll() {
        return gamePostRepository.findAll();
    }

    public Page<GamePost> findByKeyword(String keyword, String keywordType, Pageable pageable) {

        Page<GamePost> page;

        if ("gameTitle".equals(keywordType)) {
            page = gamePostRepository.findByGameTitleContainingOrderByIdDesc(keyword, pageable);
        } else if ("gameTags".equals(keywordType)) {
            var tags = new HashMap<String, String>();
            tags.put("인디", "Indy");
            tags.put("액션", "Action");
            tags.put("어드밴처", "Advantage");
            tags.put("캐주얼", "casual");
            tags.put("시뮬레이션", "Simulation");
            tags.put("전략", "Strategy");
            tags.put("싱글플레이", "SinglePlay");
            tags.put("무료플레이", "FreePlay");
            tags.put("분위기있는", "Mood");
            tags.put("풍부한스토리", "Story");
            tags.put("탐험", "Exploration");
            for(var key : tags.keySet()){
                System.out.println(key);
                if(key.contains(keyword)){
                    keyword = tags.get(key);
                    break;
                }
            }
            page = gamePostRepository.findByGameTagsContainingOrderByIdDesc(keyword, pageable);
        } else {
            return Page.empty();
        }

        for (GamePost gamePost : page.getContent()) {
            gameReviewService.updateReviewStatistics(gamePost);
        }

        return page;
    }

    public Optional<GamePost> findById(long id) {
        return gamePostRepository.findById(id);
    }

    // 가격 상태(priceState)에 따라 게시물 검색
    public Page<GamePost> findByPriceState(PriceState priceState, Pageable pageable) {
        Page<GamePost> page = gamePostRepository.findByPriceStateOrderByIdDesc(priceState, pageable);

        for (GamePost gamePost : page.getContent()) {
            gameReviewService.updateReviewStatistics(gamePost);
        }

        return page;
    }

    // 게임 장르(genreCode)에 따라 게시물 검색
    public Page<GamePost> findByGenreCode(String genreCode, Pageable pageable) {
        Page<GamePost> page = gamePostRepository.findByGenreCodeOrderByIdDesc(genreCode, pageable);

        for (GamePost gamePost : page.getContent()) {
            gameReviewService.updateReviewStatistics(gamePost);
        }

        return page;
    }

    public List<GamePost> findAllByOrderByAverageRatingDesc() {
        List<GamePost> postList = gamePostRepository.findAllByOrderByAverageRatingDesc();

        for (GamePost gamePost : postList) {
            gameReviewService.updateReviewStatistics(gamePost);
        }

        return postList;
    }

    public Page<GamePost> getGamesSortedByLowestPrice(Pageable pageable) {
        Page<GamePost> postList = gamePostRepository.findAllByOrderByGamePriceAsc(pageable);

        for (GamePost gamePost : postList) {
            gameReviewService.updateReviewStatistics(gamePost);
        }

        return postList;
    }

    public Page<GamePost> getGamesSortedByHighestPrice(Pageable pageable) {
        Page<GamePost> postList = gamePostRepository.findAllByOrderByGamePriceDesc(pageable);

        for (GamePost gamePost : postList) {
            gameReviewService.updateReviewStatistics(gamePost);
        }

        return postList;
    }

    public Page<GamePost> getGamesSortedByPopularity(Pageable pageable) {
        Page<GamePost> postList = gamePostRepository.findAllByOrderByAverageRatingDesc(pageable);

        for (GamePost gamePost : postList) {
            gameReviewService.updateReviewStatistics(gamePost);
        }

        return postList;
    }


    public String getGameTitle(long id) {
        return gamePostMapper.getGameTitle(id);
    }
}
