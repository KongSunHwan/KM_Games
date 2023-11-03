package ac.kmgames.model.mapper;

import ac.kmgames.model.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GameReviewMapper {

    List<HashMap> get_game_reivew_l5(long id);

    List<HashMap> getGameSearchList(@Param("cs") Criteria cs, @Param("game_id") long game_id);

    int getGameSearchCount(@Param("cs") Criteria cs, @Param("game_id") long game_id);
}
