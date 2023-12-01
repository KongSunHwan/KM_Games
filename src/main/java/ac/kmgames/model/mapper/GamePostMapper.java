package ac.kmgames.model.mapper;

import ac.kmgames.model.dto.GameDTO;
import ac.kmgames.model.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GamePostMapper {
    String getGameTitle(long id);
}
