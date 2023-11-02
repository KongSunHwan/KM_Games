package ac.kmgames.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GameReviewMapper {

    List<HashMap> get_game_reivew_l5(long id);
}
