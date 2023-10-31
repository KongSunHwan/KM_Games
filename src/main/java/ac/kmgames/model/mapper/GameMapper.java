package ac.kmgames.model.mapper;

import ac.kmgames.model.dto.GameDTO;
import ac.kmgames.model.dto.UserDTO;
import ac.kmgames.model.entity.Game;
import ac.kmgames.model.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameMapper {

    List<GameDTO> getGameListAdmin(Criteria cs);

    int getCount(Criteria cs);

    List<GameDTO> getGameSearch(Criteria cs);

    int getGameSearch_cnt(Criteria cs);

    List<GameDTO> get_game_info(long id);
}
