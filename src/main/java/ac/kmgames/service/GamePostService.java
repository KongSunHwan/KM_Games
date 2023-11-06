package ac.kmgames.service;

import ac.kmgames.model.dto.GamePostDTO;
import ac.kmgames.model.entity.GamePhoto;
import ac.kmgames.model.entity.GamePost;
import ac.kmgames.model.repository.GamePhotoRepository;
import ac.kmgames.model.repository.GamePostRepository;
import ac.kmgames.model.utils.FileUtilities;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
public class GamePostService {
    private final GamePostRepository gamePostRepository;
    private final GamePhotoRepository gamePhotoRepository;

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
}
