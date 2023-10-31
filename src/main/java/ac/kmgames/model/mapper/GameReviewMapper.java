package ac.kmgames.model.mapper;

import ac.kmgames.model.dto.GameDTO;
import ac.kmgames.model.dto.GameReviewDTO;
import ac.kmgames.model.entity.GameReview;
import ac.kmgames.model.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GameReviewMapper {

    List<HashMap> get_game_reivew_l5(long id);
}
